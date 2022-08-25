package com.example.mnist_classificaition

import android.content.Intent
import android.content.res.AssetManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel
import java.util.*


class MainActivity : AppCompatActivity() {

    var image = findViewById<ImageView>(R.id.imageview1)
    var button = findViewById<Button>(R.id.button1)
    var buttun2 = findViewById<Button>(R.id.button2)
    var textResult = findViewById<TextView>(R.id.result)
    private lateinit var classifier: Classifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{selectGallery()}

        buttun2.setOnClickListener{
            val bitmap = (image.drawable as BitmapDrawable).bitmap

            val result = classifier.classify(image)
            val outString = String.format(Locale.ENGLISH, "%d, %.0f%%", result.first, result.second * 100.0f)
            textResult.text = outString
        }
    }

    // 이미지 갤러리에서 가져오기
    private fun selectGallery() {

            var intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*");
            startActivityForResult(intent, 2000)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            if(requestCode==2000){
                val currentUri : Uri? =data?.data

                try{
                    val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(contentResolver,currentUri)
                    image?.setImageBitmap(bitmap)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }else{
            Log.d("ActivityResult","error")
        }
    }

    private fun initClassifier() {
        var classifier: Classifier = Classifier(assets, Classifier.DIGIT_CLASSIFIER)
        try {
            classifier.init()
        } catch (exception: IOException) {
            Log.d("initClassifier", "IOException")
        }
    }

    }

class Classifier(private val assetManager: AssetManager, private val modelName: String) {
    lateinit var interpreter: Interpreter

    private var modelInputChannel = 0 // 이미지 크기 확인에 사용될 변수
    private var modelInputWidth = 0
    private var modelInputHeight = 0

    private var modelOutputClasses = 0 //출력 클래스 수를 담을 변수

    fun init() {
        val model = loadModelFile()
        model.order(ByteOrder.nativeOrder())
        interpreter = Interpreter(model)
        initModelShape()
    }

    private fun loadModelFile(): ByteBuffer { // model 불러오는 함수
        val assetFileDescriptor = assetManager.openFd(modelName)
        val fileInputStream = FileInputStream(assetFileDescriptor.fileDescriptor)
        val fileChannel = fileInputStream.channel
        val startOffset = assetFileDescriptor.startOffset
        val declaredLength = assetFileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    private fun initModelShape() {    // 이미지 크기의 정보를 얻어오는 함수
        val inputTensor = interpreter.getInputTensor(0)
        val inputShape = inputTensor.shape()
        modelInputChannel = inputShape[0] //1
        modelInputWidth = inputShape[1]   //28
        modelInputHeight = inputShape[2]  //28

        val outputTensor = interpreter.getOutputTensor(0)
        val outputShape = outputTensor.shape()
        modelOutputClasses = outputShape[1] //0~9까지 10개
    }

    private fun resizeBitmap(bitmap: Bitmap) =
        Bitmap.createScaledBitmap(bitmap, modelInputWidth, modelInputHeight, false)

    companion object {
        const val DIGIT_CLASSIFIER = "mnist.tflite"
    }

    private fun convertBitmapGrayByteBuffer(bitmap: Bitmap): ByteBuffer {
        val byteBuffer = ByteBuffer.allocateDirect(bitmap.byteCount)
        byteBuffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(bitmap.width * bitmap.height)
        bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)

        //rgb 추출
        pixels.forEach { pixel ->
            val r = pixel shr 16 and 0xFF
            val g = pixel shr 8 and 0xFF
            val b = pixel and 0xFF

            val avgPixelValue = (r + g + b) / 3.0f
            val normalizedPixelValue = avgPixelValue / 255.0f

            byteBuffer.putFloat(normalizedPixelValue)
        }
        return byteBuffer
    }

    fun classify(image: Bitmap): Pair<Int, Float> {
        val buffer = convertBitmapGrayByteBuffer(resizeBitmap(image))
        val result = Array(1) { FloatArray(modelOutputClasses) { 0f } } //1행, 10 열, 초기화 값
        interpreter.run(buffer, result)
        return argmax(result[0])
    }

    private fun argmax(array: FloatArray): Pair<Int, Float> {
        var maxIndex = 0
        var maxValue = 0f
        array.forEachIndexed { index, value ->
            if (value > maxValue) {
                maxIndex = index
                maxValue = value
            }
        }
        return maxIndex to maxValue
    }
}