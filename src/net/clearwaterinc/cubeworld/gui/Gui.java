package net.clearwaterinc.cubeworld.gui;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;

public class Gui {
	public void drawRect(float x1, float y1, float x2, float y2, int color){
		glDisable(GL_LIGHTING);
		glDisable(GL_TEXTURE_2D);
		glBlendFunc(GL_SRC_ALPHA,GL_ONE);
        glColor4f(Colors.fromHex(color)[0], Colors.fromHex(color)[1], Colors.fromHex(color)[2], Colors.fromHex(color)[3]);
        glLoadIdentity();
        glTranslatef(0f, 0f, -0.1f);
        glBegin(GL_TRIANGLE_STRIP);
        	glVertex3f(x1, y1, 0);
        	glVertex3f(x2, y1, 0);
        	glVertex3f(x1, y2, 0);
        	glVertex3f(x2, y2, 0);
        glEnd();
        glTranslatef(0f, 0f, 0.1f);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_LIGHTING);
	}
	
	public void drawTexturedRect(float x1, float y1, float x2, float y2, float tx1, float ty1, float tx2, float ty2, Texture tex){
        glLoadIdentity();
        glTranslatef(0f, 0f, -0.1f);
        tex.bind();
        glBegin(GL_TRIANGLE_STRIP);
        	glTexCoord2f(1.0f, 1.0f); glVertex3f(0.002f, 0.002f, 0);
        	glTexCoord2f(0.0f, 1.0f); glVertex3f(-0.002f, 0.002f, 0);
        	glTexCoord2f(1.0f, 0.0f); glVertex3f(0.002f, -0.002f, 0);
        	glTexCoord2f(0.0f, 0.0f); glVertex3f(-0.002f, -0.002f, 0);
        glEnd();
        glTranslatef(0f, 0f, 0.1f);
	}
}
