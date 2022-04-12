package com.example.facebooksharingapi

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.facebooksharingapi.databinding.ActivityMainBinding
import com.facebook.CallbackManager
import com.facebook.share.model.*
import com.facebook.share.widget.ShareDialog

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE_IMAGE: Int = 100
    private val REQUEST_CODE_VIDEO: Int = 101
    private lateinit var binding: ActivityMainBinding
    private var callBackManager: CallbackManager? = null
    private var shareDialog: ShareDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callBackManager = CallbackManager.Factory.create()
        shareDialog = ShareDialog(this)


        binding.btnShareLink.setOnClickListener {
            val shareLink = ShareLinkContent.Builder()
                .setQuote("This is helpful link")
                .setContentUrl("https://google.com".toUri())
                .build()

            shareDialog?.show(shareLink)
        }

        binding.btnSharePhoto.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, REQUEST_CODE_IMAGE)
        }


        binding.btnShareVideo.setOnClickListener {
            val intent = Intent()
            intent.type = "video/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, REQUEST_CODE_VIDEO)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_VIDEO) {
                val selectedVideo = data?.data

                val shareVideo = ShareVideo.Builder()
                    .setLocalUrl(selectedVideo)
                    .build()


                val videoContent = ShareVideoContent.Builder()
                    .setContentTitle("This is title of a video")
                    .setContentDescription("This is a long description of a video")
                    .setVideo(shareVideo)
                    .build()

                shareDialog?.show(videoContent)
            } else if (requestCode == REQUEST_CODE_IMAGE) {

                val selectedVideo = data?.data

                val bitmap =
                    MediaStore.Images.Media.getBitmap(this.contentResolver, selectedVideo)


                val sharePhoto = SharePhoto.Builder()
                    .setBitmap(bitmap)
                    .build()

                val photoContent = SharePhotoContent.Builder()
                    .addPhoto(sharePhoto)
                    .build()


                shareDialog?.show(photoContent)


            }
        }
    }
}