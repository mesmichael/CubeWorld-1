package net.clearwaterinc.cubeworld.gui;

import static org.lwjgl.opengl.GL11.*;
import net.clearwaterinc.cubeworld.CubeWorld;

public abstract class GuiScreen {
	
	public CubeWorld cw;
	
	public GuiScreen(CubeWorld cw){
		this.cw = cw;
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_BLEND);
	}
}
