package net.clearwaterinc.cubeworld;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import net.clearwaterinc.cubeworld.entities.EntityPlayer;
import net.clearwaterinc.cubeworld.gui.Gui;
import net.clearwaterinc.cubeworld.render.RenderText;
import net.clearwaterinc.cubeworld.render.RenderWorld;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class CubeWorld {
	public boolean mouseLeft, mouseRight;
	public static boolean moveLeft, moveRight, moveUp, moveDown;
	
	public float rotation = 0;
	
	public Gui gui = new Gui();
	
	public int mouseX, mouseY;
	public int FPS;
	public int delta;
	public int width;
	public int height;
	
	public long lastFrame, lastFPS;
	
	public String OS = null;
	private static String OSv = System.getProperty("os.name").toLowerCase();

	public EntityPlayer entityPlayer;
	public RenderText renderText;
	public RenderWorld renderWorld;
	
	public void start(){
		try{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.setResizable(true);
			Display.create();
			width = Display.getWidth();
			height = Display.getHeight();
			renderWorld = new RenderWorld();
			renderText = new RenderText(this);
		}catch (LWJGLException e){
			e.printStackTrace();
			System.exit(0);
		}
		
		initGL();
		getDelta();
		lastFPS = getTime();
		entityPlayer = new EntityPlayer(0, 0, 0);

    	float dx = 0.0f;
    	float dy = 0.0f;
    	float mouseSensitivity = 0.15f;

    	Mouse.setGrabbed(true);
		while(!Display.isCloseRequested()){
			if(Display.wasResized()){
				width = Display.getWidth();
				height = Display.getHeight();
				onResize();
			}
    		dx = Mouse.getDX();
    		dy = Mouse.getDY();
    		
    		entityPlayer.yaw(dx * mouseSensitivity);
    		entityPlayer.pitch(-dy * mouseSensitivity);
			
			delta = getDelta();
			updateFPS();

			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			renderWorld.startRender();
			
			gui.drawRect(0.0005f / ((float)width / (float)800), 0.0005f / ((float)height / (float)600), -0.0005f / ((float)width / (float)800), -0.0005f / ((float)height / (float)600), 0xffffff);
			renderText.drawString(-0.053f, 0.038f, "X:" + entityPlayer.position.x);
			renderText.drawString(-0.053f, 0.035f, "Y:" + entityPlayer.position.y);
			renderText.drawString(-0.053f, 0.032f, "Z:" + entityPlayer.position.z);
			renderText.drawString(-0.053f, 0.029f, "Yaw:" + entityPlayer.yaw);
			renderText.drawString(-0.053f, 0.026f, "Pitch:" + entityPlayer.pitch);
			
    		GL11.glLoadIdentity();
    		entityPlayer.lookThrough();
			
			runChecks();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public void onResize(){
		GL11.glViewport(0, 0, width, height);
	}
	
	/**
	 * Initialize OpenGL view
	 **/
	public void initGL(){
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluPerspective(45.0f, ((float) Display.getWidth()) / ((float) Display.getHeight()), 0.1f, 100.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glClearColor(0.1f, 0.2f, 0.7f, 0.0f);
		GL11.glClearDepth(1.0f);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
		float lightAmbient[] = {255.0f, 255.0f, 255.0f, 255.0f};
		float lightDiffuse[] = {1.0f, 1.0f, 1.0f, 1.0f};
		float lightPosition[] = {0.0f, 0.0f, 255.0f, 255.0f};
		
		ByteBuffer temp = ByteBuffer.allocateDirect(16);
		temp.order(ByteOrder.nativeOrder());
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_AMBIENT, (FloatBuffer) temp.asFloatBuffer().put(lightAmbient).flip());
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_DIFFUSE, (FloatBuffer) temp.asFloatBuffer().put(lightDiffuse).flip());
		GL11.glLight(GL11.GL_LIGHT2, GL11.GL_POSITION, (FloatBuffer) temp.asFloatBuffer().put(lightPosition).flip());
		GL11.glEnable(GL11.GL_LIGHT2);
	}
	
	/**
	 * Runs every tick to check mouse X & Y, checks keys, etc.
	 */
	public void runChecks(){
		initKeys();
		monitorInput();
	}
	
	public void initKeys(){
		mouseLeft = Mouse.isButtonDown(0);
		mouseRight = Mouse.isButtonDown(1);
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
	}
	
	public void monitorInput(){
		float dt = 0.0005f;
    	float movementSpeed = 10.0f;
		if (Keyboard.isKeyDown(Keyboard.KEY_W)){
			entityPlayer.walkForward(movementSpeed*dt);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)){
			entityPlayer.walkBackwards(movementSpeed*dt);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)){
			entityPlayer.strafeLeft(movementSpeed*dt);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)){
			entityPlayer.strafeRight(movementSpeed*dt);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			entityPlayer.flyUp(movementSpeed*dt);
		}
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
				if(Keyboard.getEventKey() == Keyboard.KEY_ESCAPE){
					Display.destroy();
				}
			}else{

			}
		}
	}
	
	public String getDir(){
        String dir = System.getProperty("user.home", ".");
        File save = new File(dir, "cubeworld/");
		
		if (isWindows()) {
			String appData = System.getenv("APPDATA");
			
			if (appData != null){
				save = new File(appData, "." + "cubeworld" + '/');
			}else{
				save = new File(dir, '.' + "cubeworld" + '/');
			}
		} else if (isMac()) {
			save = new File(dir, "Library/Application Support/" + "cubeworld");
		} else if (isUnix()) {
			save = new File(dir, '.' + "cubeworld" + '/');
		} else if (isSolaris()) {
			save = new File(dir, "cubeworld" + '/');
		} else {
			save = new File(dir, "cubeworld/");
		}
		
		return save.toString();
	}
	
	public static boolean isWindows() {
		 
		return (OSv.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		return (OSv.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		return (OSv.indexOf("nix") >= 0 || OSv.indexOf("nux") >= 0 || OSv.indexOf("aix") > 0 );
 
	}
 
	public static boolean isSolaris() {
 
		return (OSv.indexOf("sunos") >= 0);
 
	}
	
	public long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public int getDelta(){
		long time = getTime();
		int delta = (int)(time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
	
	public int getFPS(){
		return FPS;
	}
	
	public void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			Display.setTitle("FPS: " + FPS);
			FPS = 0;
			lastFPS += 1000;
		}
		FPS++;
	}
}