package com.example.meepmeeptesting.colorschemes

import com.noahbres.meepmeep.core.colorscheme.ColorPalette
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark
import java.awt.Color

class BlueColorScheme: ColorSchemeBlueDark() {
    override val TRAJECTORY_PATH_COLOR: Color = ColorPalette.DEFAULT_PALETTE.BLUE_500
}