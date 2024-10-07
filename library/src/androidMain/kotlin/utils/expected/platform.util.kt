package utils.expected

import android.os.Build
import android.os.Debug
import org.cognitox.clientlib.BuildConfig
import java.util.UUID


actual fun uuid(): String = UUID.randomUUID().toString()

actual val isDebug = BuildConfig.DEBUG || isEmulator

private val isEmulator: Boolean
	get() = (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
			|| Build.FINGERPRINT.startsWith("generic")
			|| Build.FINGERPRINT.startsWith("unknown")
			|| Build.HARDWARE.contains("goldfish")
			|| Build.HARDWARE.contains("ranchu")
			|| Build.MODEL.contains("google_sdk")
			|| Build.MODEL.contains("Emulator")
			|| Build.MODEL.contains("Android SDK built for x86")
			|| Build.MANUFACTURER.contains("Genymotion")
			|| Build.PRODUCT.contains("sdk_google")
			|| Build.PRODUCT.contains("google_sdk")
			|| Build.PRODUCT.contains("sdk")
			|| Build.PRODUCT.contains("sdk_x86")
			|| Build.PRODUCT.contains("sdk_gphone64_arm64")
			|| Build.PRODUCT.contains("vbox86p")
			|| Build.PRODUCT.contains("emulator")
			|| Build.PRODUCT.contains("simulator")
			|| Debug.isDebuggerConnected()


actual fun platform(): Platforms = Platforms.ANDROID
