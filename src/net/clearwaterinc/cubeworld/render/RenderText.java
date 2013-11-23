package net.clearwaterinc.cubeworld.render;

import static org.lwjgl.opengl.GL11.*;

import java.io.FileInputStream;

import net.clearwaterinc.cubeworld.CubeWorld;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class RenderText {
	
	public CubeWorld cw;
	Texture texture;
	
	public RenderText(CubeWorld cw){
		this.cw = cw;
		texture = getTexture(cw.getDir() + "/res/font.png");
	}
	
	public void drawString(float x, float y, String string){
		char[] letters = string.toCharArray();
		float newY = y / ((float)cw.height / (float)600);
		float Y = newY;
		if((float)cw.height / (float)600 != 1){
			Y = newY + (Y / 2);
		}
		for(int i = 0; i < letters.length; i++){
			drawLetter(x + (i * 0.0015f) / ((float)cw.width / (float)800), Y, letters[i]);
		}
	}
	
	private void drawLetter(float x, float y, char letter){
		switch(letter){
			case 'A':
				drawChar(x, y, getCharPos(0), getCharPos(0), getCharPos(1), getCharPos(1), texture);
				break;
			case 'B':
				drawChar(x, y, getCharPos(1), getCharPos(0), getCharPos(2), getCharPos(1), texture);
				break;
			case 'C':
				drawChar(x, y, getCharPos(2), getCharPos(0), getCharPos(3), getCharPos(1), texture);
				break;
			case 'D':
				drawChar(x, y, getCharPos(3), getCharPos(0), getCharPos(4), getCharPos(1), texture);
				break;
			case 'E':
				drawChar(x, y, getCharPos(4), getCharPos(0), getCharPos(5), getCharPos(1), texture);
				break;
			case 'F':
				drawChar(x, y, getCharPos(5), getCharPos(0), getCharPos(6), getCharPos(1), texture);
				break;
			case 'G':
				drawChar(x, y, getCharPos(6), getCharPos(0), getCharPos(7), getCharPos(1), texture);
				break;
			case 'H':
				drawChar(x, y, getCharPos(7), getCharPos(0), getCharPos(8), getCharPos(1), texture);
				break;
			case 'I':
				drawChar(x, y, getCharPos(8), getCharPos(0), getCharPos(9), getCharPos(1), texture);
				break;
			case 'J':
				drawChar(x, y, getCharPos(9), getCharPos(0), getCharPos(10), getCharPos(1), texture);
				break;
			case 'K':
				drawChar(x, y, getCharPos(10), getCharPos(0), getCharPos(11), getCharPos(1), texture);
				break;
			case 'L':
				drawChar(x, y, getCharPos(11), getCharPos(0), getCharPos(12), getCharPos(1), texture);
				break;
			case 'M':
				drawChar(x, y, getCharPos(12), getCharPos(0), getCharPos(13), getCharPos(1), texture);
				break;
			case 'N':
				drawChar(x, y, getCharPos(13), getCharPos(0), getCharPos(14), getCharPos(1), texture);
				break;
			case 'O':
				drawChar(x, y, getCharPos(14), getCharPos(0), getCharPos(15), getCharPos(1), texture);
				break;
			case 'P':
				drawChar(x, y, getCharPos(15), getCharPos(0), getCharPos(16), getCharPos(1), texture);
				break;
			case 'Q':
				drawChar(x, y, getCharPos(0), getCharPos(1), getCharPos(1), getCharPos(2), texture);
				break;
			case 'R':
				drawChar(x, y, getCharPos(1), getCharPos(1), getCharPos(2), getCharPos(2), texture);
				break;
			case 'S':
				drawChar(x, y, getCharPos(2), getCharPos(1), getCharPos(3), getCharPos(2), texture);
				break;
			case 'T':
				drawChar(x, y, getCharPos(3), getCharPos(1), getCharPos(4), getCharPos(2), texture);
				break;
			case 'U':
				drawChar(x, y, getCharPos(4), getCharPos(1), getCharPos(5), getCharPos(2), texture);
				break;
			case 'V':
				drawChar(x, y, getCharPos(5), getCharPos(1), getCharPos(6), getCharPos(2), texture);
				break;
			case 'W':
				drawChar(x, y, getCharPos(6), getCharPos(1), getCharPos(7), getCharPos(2), texture);
				break;
			case 'X':
				drawChar(x, y, getCharPos(7), getCharPos(1), getCharPos(8), getCharPos(2), texture);
				break;
			case 'Y':
				drawChar(x, y, getCharPos(8), getCharPos(1), getCharPos(9), getCharPos(2), texture);
				break;
			case 'Z':
				drawChar(x, y, getCharPos(9), getCharPos(1), getCharPos(10), getCharPos(2), texture);
				break;		
			case '1':
				drawChar(x, y, getCharPos(10), getCharPos(1), getCharPos(11), getCharPos(2), texture);
				break;
			case '2':
				drawChar(x, y, getCharPos(11), getCharPos(1), getCharPos(12), getCharPos(2), texture);
				break;
			case '3':
				drawChar(x, y, getCharPos(12), getCharPos(1), getCharPos(13), getCharPos(2), texture);
				break;
			case '4':
				drawChar(x, y, getCharPos(13), getCharPos(1), getCharPos(14), getCharPos(2), texture);
				break;
			case '5':
				drawChar(x, y, getCharPos(14), getCharPos(1), getCharPos(15), getCharPos(2), texture);
				break;
			case '6':
				drawChar(x, y, getCharPos(15), getCharPos(1), getCharPos(16), getCharPos(2), texture);
				break;
			case '7':
				drawChar(x, y, getCharPos(0) + 0.0005f, getCharPos(2), getCharPos(1), getCharPos(3), texture);
				break;
			case '8':
				drawChar(x, y, getCharPos(1), getCharPos(2), getCharPos(2), getCharPos(3), texture);
				break;
			case '9':
				drawChar(x, y, getCharPos(2), getCharPos(2), getCharPos(3), getCharPos(3), texture);
				break;
			case '0':
				drawChar(x, y, getCharPos(3), getCharPos(2), getCharPos(4), getCharPos(3), texture);
				break;
			case '!':
				drawChar(x, y, getCharPos(4), getCharPos(2), getCharPos(5), getCharPos(3), texture);
				break;
			case '?':
				drawChar(x, y, getCharPos(5), getCharPos(2), getCharPos(6), getCharPos(3), texture);
				break;
			case ',':
				drawChar(x, y - 0.0007f, getCharPos(6), getCharPos(2), getCharPos(7), getCharPos(3), texture);
				break;
			case '.':
				drawChar(x, y, getCharPos(7), getCharPos(2), getCharPos(8), getCharPos(3), texture);
				break;
			case '/':
				drawChar(x, y, getCharPos(8), getCharPos(2), getCharPos(9), getCharPos(3), texture);
				break;
			case '\'':
				drawChar(x, y, getCharPos(9), getCharPos(2), getCharPos(10), getCharPos(3), texture);
				break;
			case ':':
				drawChar(x, y, getCharPos(10), getCharPos(2), getCharPos(11), getCharPos(3), texture);
				break;
			case ';':
				drawChar(x, y, getCharPos(11), getCharPos(2), getCharPos(12), getCharPos(3), texture);
				break;
			case '-':
				drawChar(x, y, getCharPos(12), getCharPos(2), getCharPos(13), getCharPos(3), texture);
				break;
			case '+':
				drawChar(x, y, getCharPos(13), getCharPos(2), getCharPos(14), getCharPos(3), texture);
				break;
			case '=':
				drawChar(x, y, getCharPos(14), getCharPos(2), getCharPos(15), getCharPos(3), texture);
				break;
			case ' ':
				break;
			case 'a':
				drawChar(x, y, getCharPos(0), getCharPos(3), getCharPos(1), getCharPos(4), texture);
				break;
			case 'b':
				drawChar(x, y, getCharPos(1), getCharPos(3), getCharPos(2), getCharPos(4), texture);
				break;
			case 'c':
				drawChar(x, y, getCharPos(2), getCharPos(3), getCharPos(3), getCharPos(4), texture);
				break;
			case 'd':
				drawChar(x, y, getCharPos(3), getCharPos(3), getCharPos(4), getCharPos(4), texture);
				break;
			case 'e':
				drawChar(x, y, getCharPos(4), getCharPos(3), getCharPos(5), getCharPos(4), texture);
				break;
			case 'f':
				drawChar(x, y, getCharPos(5), getCharPos(3), getCharPos(6), getCharPos(4), texture);
				break;
			case 'g':
				drawChar(x, y, getCharPos(6), getCharPos(3), getCharPos(7), getCharPos(4), texture);
				break;
			case 'h':
				drawChar(x, y, getCharPos(7), getCharPos(3), getCharPos(8), getCharPos(4), texture);
				break;
			case 'i':
				drawChar(x, y, getCharPos(8), getCharPos(3), getCharPos(9), getCharPos(4), texture);
				break;
			case 'j':
				drawChar(x, y, getCharPos(9), getCharPos(3), getCharPos(10), getCharPos(4), texture);
				break;
			case 'k':
				drawChar(x, y, getCharPos(10), getCharPos(3), getCharPos(11), getCharPos(4), texture);
				break;
			case 'l':
				drawChar(x, y, getCharPos(11), getCharPos(3), getCharPos(12), getCharPos(4), texture);
				break;
			case 'm':
				drawChar(x, y, getCharPos(12), getCharPos(3), getCharPos(13), getCharPos(4), texture);
				break;
			case 'n':
				drawChar(x, y, getCharPos(13), getCharPos(3), getCharPos(14), getCharPos(4), texture);
				break;
			case 'o':
				drawChar(x, y, getCharPos(14), getCharPos(3), getCharPos(15), getCharPos(4), texture);
				break;
			case 'p':
				drawChar(x, y, getCharPos(15), getCharPos(3), getCharPos(16), getCharPos(4), texture);
				break;
			case 'q':
				drawChar(x, y, getCharPos(0), getCharPos(4), getCharPos(1), getCharPos(5), texture);
				break;
			case 'r':
				drawChar(x, y, getCharPos(1), getCharPos(4), getCharPos(2), getCharPos(5), texture);
				break;
			case 's':
				drawChar(x, y, getCharPos(2), getCharPos(4), getCharPos(3), getCharPos(5), texture);
				break;
			case 't':
				drawChar(x, y, getCharPos(3), getCharPos(4), getCharPos(4), getCharPos(5), texture);
				break;
			case 'u':
				drawChar(x, y, getCharPos(4), getCharPos(4), getCharPos(5), getCharPos(5), texture);
				break;
			case 'v':
				drawChar(x, y, getCharPos(5), getCharPos(4), getCharPos(6), getCharPos(5), texture);
				break;
			case 'w':
				drawChar(x, y, getCharPos(6), getCharPos(4), getCharPos(7), getCharPos(5), texture);
				break;
			case 'x':
				drawChar(x, y, getCharPos(7), getCharPos(4), getCharPos(8), getCharPos(5), texture);
				break;
			case 'y':
				drawChar(x, y, getCharPos(8), getCharPos(4), getCharPos(9), getCharPos(5), texture);
				break;
			case 'z':
				drawChar(x, y, getCharPos(9), getCharPos(4), getCharPos(10), getCharPos(5), texture);
				break;	
			default:
				drawChar(x, y, getCharPos(15), getCharPos(15), getCharPos(16), getCharPos(16), texture);
				break;
		}
	}
	
	private float getCharPos(float texPos){
		return (texPos / 16) + 0.0005f;
	}
	
	private Texture getTexture(String path){
		try{
			return TextureLoader.getTexture("PNG", new FileInputStream(path));
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}
	
	private void drawChar(float x, float y, float tx1, float ty1, float tx2, float ty2, Texture tex){
        glLoadIdentity();
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glTranslatef(x, y, -0.1f);
        glRotatef(90, 0, 0, 1);
        tex.bind();
        glBegin(GL_TRIANGLE_STRIP);
        	glTexCoord2f(tx1, ty1); glVertex3f(0.001f / ((float)cw.width / (float)800), 0.001f / ((float)cw.height / (float)600), 0);
        	glTexCoord2f(tx1, ty2); glVertex3f(-0.001f / ((float)cw.width / (float)800), 0.001f / ((float)cw.height / (float)600), 0);
        	glTexCoord2f(tx2, ty1); glVertex3f(0.001f / ((float)cw.width / (float)800), -0.001f / ((float)cw.height / (float)600), 0);
        	glTexCoord2f(tx2, ty2); glVertex3f(-0.001f / ((float)cw.width / (float)800), -0.001f / ((float)cw.height / (float)600), 0);
        glEnd();
        glTranslatef(-x, -y, 0.1f);
        glDisable(GL_BLEND);
        glTranslatef(0, 0, 0);
	}
}
