# Facebook-Sharing-API-Android
Sharing Data on Facebook using facebook sharing api

https://scontent.fisb6-1.fna.fbcdn.net/v/t39.2178-6/11057184_822163927854102_637828047_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=5ca315&_nc_eui2=AeHh5QmyOpTuftm1xhS8SZL8I-7Z7Fr7Gi8j7tnsWvsaL4DC15OJVCvtdRjxWm-ifOmGWYMQhyNy5_SKMyzOGBc-&_nc_ohc=yqGJC9KeaUAAX8dyN-g&_nc_ht=scontent.fisb6-1.fna&oh=00_AT-i4Z3OA2v5sxn4SyXNF4D6pLna5C8auGlG7s0a6gaElA&oe=625B565B
https://scontent.fisb6-1.fna.fbcdn.net/v/t39.2178-6/11057184_822163927854102_637828047_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=5ca315&_nc_eui2=AeHh5QmyOpTuftm1xhS8SZL8I-7Z7Fr7Gi8j7tnsWvsaL4DC15OJVCvtdRjxWm-ifOmGWYMQhyNy5_SKMyzOGBc-&_nc_ohc=yqGJC9KeaUAAX8dyN-g&_nc_ht=scontent.fisb6-1.fna&oh=00_AT-i4Z3OA2v5sxn4SyXNF4D6pLna5C8auGlG7s0a6gaElA&oe=625B565B


STEPS REQUIRED
Get your Facebook App ID properly configured and linked to your Android app.

1- If you don't have a Facebook App ID for your app yet, see Facebook SDK Quick Start for Android.
2- Find your Facebook App ID on the Apps page of the developer portal and then see Add Your Facebook App ID and Client Token.
3- Generate an Android development key hash and add it to the Sample Apps page of your developer settings. For details, see Create a Development Key Hash and Running Sample Apps.

Add a ContentProvider to your AndroidManifest.xml file and set {APP_ID} to your app ID:

<provider android:authorities="com.facebook.app.FacebookContentProvider{APP_ID}"
android:name="com.facebook.FacebookContentProvider"
android:exported="true"/>

If your application targets Android 11 or later, add the following queries block to your AndroidManifest.xml file to make the Facebook App visible to your App:

<queries>
<provider android:authorities="com.facebook.katana.provider.PlatformProvider" /> 
</queries>
