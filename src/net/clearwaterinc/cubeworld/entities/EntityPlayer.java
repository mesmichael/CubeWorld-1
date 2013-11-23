package net.clearwaterinc.cubeworld.entities;

import net.clearwaterinc.cubeworld.CubeWorld;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class EntityPlayer {
	
	public float yaw = 0.0f, pitch = 0.0f;
	
	public Vector3f position = null;
	
	public static float x, y, z;
	
	public CubeWorld cw = new CubeWorld();
	
	public EntityPlayer(float x, float y, float z)
    {
        position = new Vector3f(x, y, z);
    }
	
    public void yaw(float amount){
    	yaw += amount;
    	if(yaw > 180.0f){
    		yaw = -180.0f;
    	}
    	if(yaw < -180.0f){
    		yaw = 180.0f;
    	}
    }
 
    public void pitch(float amount){
    	pitch += amount;
    	if(pitch > 180.0f){
    		pitch = -180.0f;
    	}
    	if(pitch < -180.0f){
    		pitch = 180.0f;
    	}
    }

    public void walkForward(float distance){
    	if(position.z > 10.108f && position.y < 20.216f){
    		position.y += distance * (float)Math.sin(Math.toRadians(yaw + 90));
    		position.x += distance * (float)Math.cos(Math.toRadians(yaw + 90));
    		if(position.y <= 0){
    	    	if(pitch > 0.0f) pitch -= 180;
    	    	if(pitch < 0.0f) pitch += 180.0f;
        		if(position.y < 0){
        			position.y = 0;
        			position.z = 10.107f;
        		}
    		}
    		if(position.y >= 20.216f){
        		if(position.y < 20.216f){
        			position.y = 20.216f;
        		}
    		}
    	}else if(position.z <= -10.108f && position.y < 20.216f){
    		position.y -= distance * (float)Math.sin(Math.toRadians(-(yaw - 90)));
    		position.x -= distance * (float)Math.cos(Math.toRadians(-(yaw - 90)));
    		if(position.y <= 0){
        		position.y -= 0.1f;
        		if(position.y < 0){
        			position.y = 0;
        			position.z = -10.107f;
        		}
    		}
    	}else if(position.x >= 10.107 && position.y > 0){
    		position.y += distance * (float)Math.sin(Math.toRadians(-(yaw - 180)));
    		position.z += distance * (float)Math.cos(Math.toRadians(-(yaw - 180)));
    	}else if(position.x <= -10.107 && position.y > 0){
    		position.y += distance * (float)Math.sin(Math.toRadians(yaw));
    		position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    		if(position.y < 0){
    	    	if(pitch > 0.0f) pitch -= 90;
    	    	if(pitch < 0.0f) pitch += 90;
    		}
    	}else if(position.y <= 0){
    		position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
    		position.z += distance * (float)Math.cos(Math.toRadians(yaw));
    		if(position.x >= 10.107){
    	    	if(pitch > 0.0f) pitch += 180;
    	    	if(pitch < 0.0f) pitch -= 180;
    			position.x = 10.108f;
    	    	position.y = 0.001f;
    		}
    		if(position.x <= -10.107){
    	    	if(pitch > 0.0f) pitch -= 90;
    	    	if(pitch < 0.0f) pitch += 90;
    	    	position.y = 0.001f;
    		}
    	}else if(position.y >= 20.216f){
    		position.x -= distance * (float)Math.sin(Math.toRadians(yaw));
    		position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    		if(position.y <= 20.216f){
    			//pitch -= 90;
        		position.y += 0.1f;
        		if(position.y < 0){
        			position.y = 0;
        			position.z = 10.107f;
        		}
    		}
    		if(position.z <= -10.107f){
    			position.y = 20.20159f;
    		}
    	}
    }

    public void walkBackwards(float distance){
    	if(position.z > 10.108f){
    		position.y -= distance * (float)Math.sin(Math.toRadians(yaw + 90));
    		position.x -= distance * (float)Math.cos(Math.toRadians(yaw + 90));
    	}else if(position.z < -10.108f){
    		position.y += distance * (float)Math.sin(Math.toRadians(-(yaw - 90)));
    		position.x += distance * (float)Math.cos(Math.toRadians(-(yaw - 90)));
    	}else{
    		position.x += distance * (float)Math.sin(Math.toRadians(yaw));
    		position.z -= distance * (float)Math.cos(Math.toRadians(yaw));
    	}
    }

    public void strafeLeft(float distance){
    	position.x -= distance * (float)Math.sin(Math.toRadians(yaw - 90));
    	position.z += distance * (float)Math.cos(Math.toRadians(yaw - 90));
    }

    public void strafeRight(float distance){
    	position.x -= distance * (float)Math.sin(Math.toRadians(yaw + 90));
    	position.z += distance * (float)Math.cos(Math.toRadians(yaw + 90));
    }
    
    public void flyUp(float distance){
    	position.y -= distance;
    }
    
    public void lookThrough()
    {
    	if(position.x >= 10.108f){
    		GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
    		GL11.glRotatef(pitch, 0.0f, -1.0f, 0.0f);
    		GL11.glRotatef(yaw, -1.0f, 0.0f, 0.0f);	
    	}else if(position.x <= -10.108){
    		GL11.glRotatef(90, 0.0f, 0.0f, 1.0f);
    		GL11.glRotatef(pitch, 0.0f, -1.0f, 0.0f);
    		GL11.glRotatef(yaw, 1.0f, 0.0f, 0.0f);
    	}else if(position.z > 10.108f && position.y < 20.216f && position.x < 10.108f){
    		GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
    		GL11.glRotatef(yaw, 0.0f, 0.0f, -1.0f);
    	}else if(position.z < -10.108f && position.x < 10.108f){
    		GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
    		GL11.glRotatef(yaw, 0.0f, 0.0f, 1.0f);
    	}else if(position.y <= 0 && position.x < 10.108f){
    		GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
    		GL11.glRotatef(yaw, 0.0f, 1.0f, 0.0f);
    	}else if(position.y >= 20.216f && position.x < 10.108f){
    		GL11.glRotatef(pitch, 1.0f, 0.0f, 0.0f);
    		GL11.glRotatef(yaw, 0.0f, -1.0f, 0.0f);
    	}
        
        GL11.glTranslatef(position.x, position.y, position.z);
    }
    
    public static void setX(float X){x = X;}
    public static void setY(float Y){y = Y;}
    public static void setZ(float Z){z = Z;}
    
    public static float getX(){return x;}
    public static float getY(){return y;}
    public static float getZ(){return z;}
	
	public EntityPlayer(){}
}