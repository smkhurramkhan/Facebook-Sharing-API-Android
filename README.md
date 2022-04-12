# Facebook-Sharing-API-Android
Sharing Data on Facebook using facebook sharing api



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
