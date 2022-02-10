/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a.blockchain_voating;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.sql.Time;
import java.time.LocalDateTime;
/**
 *
 * @author ai365ak
 */
public class Block {

    public int index;
    
    public LocalDateTime time;
    public String previous_hash;
    public int nonce=0;
    public  String str;
    public String name;
     public String id;
     public int group;
    private String msgHash;
    public Block(int index,LocalDateTime time,String previous_hash,int nonce,String name,String id,int group)
    {
        this.index=index;
        this.time=LocalDateTime.now();
        this.previous_hash=previous_hash;
        this.nonce=0;
        this.name=name;
        this.id=id;
        this.group=group;
    }

    /**
     *
     * @return
     */
    public String compute_hash(Block block)
    {
        str=String.valueOf(block.index)+String.valueOf(block.time)+block.previous_hash+String.valueOf(block.nonce);    
        try
        {
            MessageDigest md=MessageDigest.getInstance("SHA-256");
            
            byte[] hash=md.digest(this.str.getBytes());
             msgHash=toHexString(hash);
            return msgHash;
        }
        catch(Exception e)
        {
            return "Error";
        }
       
    }
     public String toHexString(byte[] array) {
        StringBuilder sb=new StringBuilder(array.length*2);
        for(byte b:array)
        {
            int value=0xFF &b;
            String toAppend=Integer.toHexString(value);
            sb.append(toAppend);
        }
        sb.setLength(sb.length()-1);
        return sb.toString().toUpperCase();
    }
    
    
}
