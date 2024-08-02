package com.example.meepmeeptesting.colorschemes

import com.noahbres.meepmeep.core.colorscheme.ColorPalette
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark
import java.awt.Color

class RedColorScheme: ColorSchemeRedDark() {
    override val TRAJECTORY_PATH_COLOR: Color = ColorPalette.DEFAULT_PALETTE.RED_600
}