package com.codingcat.task.alfred.general.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codingcat.task.alfred.R

@Immutable
data class AlfredTypography(
    val sb1: TextStyle,
    val sb2: TextStyle,
    val sb3: TextStyle,
    val sb4: TextStyle,
    val md1: TextStyle,
    val reg1: TextStyle,
    val reg2: TextStyle,
    val lgh1: TextStyle,
    val lgh2: TextStyle,
)

val LocalAlfredTypography = staticCompositionLocalOf {
    AlfredTypography(
        sb1 = TextStyle.Default,
        sb2 = TextStyle.Default,
        sb3 = TextStyle.Default,
        sb4 = TextStyle.Default,
        md1 = TextStyle.Default,
        reg1 = TextStyle.Default,
        reg2 = TextStyle.Default,
        lgh1 = TextStyle.Default,
        lgh2 = TextStyle.Default
    )
}

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold)
)

val sb1 = TextStyle(
    fontSize = 46.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.SemiBold
)

val sb2 = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.SemiBold
)

val sb3 = TextStyle(
    fontSize = 23.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.SemiBold
)

val sb4 = TextStyle(
    fontSize = 32.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.SemiBold
)

val md1 = TextStyle(
    fontSize = 23.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Medium
)
val reg1 = TextStyle(
    fontSize = 23.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal
)
val reg2 = TextStyle(
    fontSize = 16.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Normal
)
val lgh1 = TextStyle(
    fontSize = 20.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Light
)
val lgh2 = TextStyle(
    fontSize = 23.sp,
    fontFamily = poppinsFontFamily,
    fontWeight = FontWeight.Light
)

val Typography = AlfredTypography(
    sb1 = sb1,
    sb2 = sb2,
    sb3 = sb3,
    sb4 = sb4,
    md1 = md1,
    reg1 = reg1,
    reg2 = reg2,
    lgh1 = lgh1,
    lgh2 = lgh2
)
