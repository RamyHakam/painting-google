/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.*;

/**
 *
 * @author Ramy
 */

public class Logo {

    /**
     * @param args the command line arguments
     */
    
    static String totalCommend[]= null;
    static int total=-1;
 static   int row; static int col;
 static String name;
    public static void main(String[] args) {
        // TODO code application logic here
      Charset charset = Charset.forName("US-ASCII");
      //Set The name for input file here 
      //Example "logo" or "learn_and_teach","right_angle"
      ///////////////////////////////////////////////////////////
                  name="right_angle"; /////////////////
       //////////////////////////////////
       /////////////////////////////////
    Path file=Paths.get("./"+name+".in");
try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
    String line = null;
   char   data [][]=null;
      line = reader.readLine();
      //for (int k=0;k<line.length();k++){
       // if(line.charAt(k)!=' ');
        String RC[] =line.split(" ");
      //}
        
          row = Integer.parseInt(RC[0]);
          col = Integer.parseInt(RC[1]);
           int maxdim= (row-1)/2;
          
       System.out.println(maxdim);
    
     data = new char [row][col] ;
     
     totalCommend=new String [row*col];
     
 
      for(int i=0;i<row;i++ ){
          line = reader.readLine();
      for (int j=0;j<col;j++){
          data[i][j]=line.charAt(j); 
          
          
      }
   
      }
     
      int temp[][]=new int [row][col];
      temp=transform(data);
      for (int l=maxdim;l>=1;l--){
    temp =square(temp,l);}
      TempPicOutput(temp);
    
  temp=linearPainting(temp);
  LinearTempPicOutput(temp);
  temp=ZerosquerCheck(temp);
  ZeroSqaureTempPicOutput(temp);
  outputfile();
 // System.out.println("-------------------------------------------------");
       
         for( int x=0;x<row;x++ ){
         
      for (  int y=0;y<col;y++){
           
          if (temp[x][y]==0){
      System.out.print(".");}
           else{ System.out.print(temp[x][y]);} 
      }
     
       System.out.println();
      }
    
} catch (IOException x) {
    System.err.format("IOException: %s%n", x);
}
    
    
    }  
    public static int [][] transform( char a[][]){
    
    int temp[][] = null;
    temp = new int [row][col];
    for (int i = 0;i<row;i++){
    for (int j=0;j<col;j++){
    if (a[i][j]=='.'){
    
     temp [i][j]=0;}
    if (a[i][j]=='#'){
    
        temp[i][j]=1;}
    
    }
   
    }

    return temp;
    }
    public static int  [][] square(int a[][],int dim) throws FileNotFoundException{
        String command[]=new String[a.length];
         System.out.println("Serach For  Square  in dimantion of  " +" "+dim );
        int t=0;
    int temp[][]= a;
   for (int i = 0;i<row;i++){
    for (int j=0;j<col;j++){
        int cell= temp[i][j];
        if (cell==5^cell==9){
         
            continue;
       }
        if (i-dim>=0&i+dim<row&j-dim>=0&j+dim<col){
            t=0;
           //System.out.println(i+" "+j);
        for (int x=i-dim;x<=i+dim;x++){
            int count=0;
          //  System.out.println(" ");
        for (int y=j-dim;y<=j+dim;y++){
          //  int tem=temp[x][y];
            if(temp[x][y]==5){ 
                if (count>=(2*dim)){ break;}
                else {
                count=+1;}}
            
            if(temp[x][y]==9){break;}
           //if (temp[x][y]==5){break;}
            if(temp[x][y]==1){
        t = t+1;}
            
            
         
        //      System.out.print(" "+temp[x][y]);
     
        }
        }
         //System.out.println(" ");
      
        if (t==(4*(dim*dim))+(4*dim)+1) {
          System.out.println("Square operation of dimn"+  dim +"center on"+i+","+j);
         SquarePainting(i,j,dim);
         
         for (int x=i-dim;x<=i+dim;x++){
             
             
        for (int y=j-dim;y<=j+dim;y++){
      
         temp[x][y]=5;
            if (x==i&y==j){temp[x][y]=9;}
        }
        }
        
        }
        /////////////////////////////////////////
       // t>(4*(dim*dim))+(2*dim)+1
        else { if (false) {
          System.out.println("Square with Earising operations operation of dimn"+  dim +"center on"+i+","+j);
         SquarePainting(i,j,dim);
         
         for (int x=i-dim;x<=i+dim;x++){
             
             
        for (int y=j-dim;y<=j+dim;y++){
         if(temp[x][y]==1){
         temp[x][y]=5;
            if (x==i&y==j){temp[x][y]=9;}
         }
         else{if(temp[x][y]==0)temp[x][y]=3;}
        }
        }
       temp=eraseing(temp); 
        }
        
        }
        
        
        }
   
    }
   }
  


        return temp;
    }
    public static void SquarePainting( int i ,int j,int d) throws FileNotFoundException{
    try{
       
        	File file =new File("FinalSquareComends.txt");
                if(!file.exists()){
    			file.createNewFile();}
                
            String commend="PAINT_SQUARE"+" "+i+" "+j+" "+ d;
                FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	        bufferWritter.write(commend);
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    total=total+1;
totalCommend[total]=commend;
    }  
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }

      public static void TempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterSquarePainting.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),false);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        
          for(int x=0;x<row;x++ ){
         
      for (int y=0;y<col;y++){
           
            bufferWritter.write(" "+a[x][y]);
           
      }
      bufferWritter.newLine();
      }
        
       bufferWritter.close();
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
    
    
  
    
    
    
 public  static int [][] linearPainting(int a[][]) throws FileNotFoundException{
 int temp=0,temp1=0,temp2=0,temp3=0;
 int r=0,c=0;
 for (int i=0;i<row;i++){
 
 for (int j=0;j<col;j++){
    
     
   
     if (a[i][j]==5){continue;}
      if (a[i][j]==9){continue;}
       if (a[i][j]==6){continue;}
       if (a[i][j]==7){continue;}
       if(a[i][j]==0){continue; }
    temp2=temp=a[i][j];
    c=0;
    r=0;

    for (int y=j;y<col;y++){
       
  
      if(a[i][y]==1^a[i][y]==7){
       temp1=temp;
        c=y;
   
       temp=temp+a[i][y];
       
      
    }
  
      else{
        
       break;}
     
    }
    
    
    
    
    for(int x=i;x<row;x++){
         
      
         if(a[x][j]==1^a[x][j]==6){
    temp3=temp2;
    temp2=temp2+a[x][j];
 r=x;   
  
    
 }
    else{break;}
    }
    if (temp2==temp&temp==a[i][j]){
    
       continue;
      
    }
    temp=temp;
    temp2=temp2;
    if (temp>temp2){
      
      
       System.out.println("Horzintal Painting from "+i+","+j+" To "+i+","+c); 
    for(int k=j;k<=c;k++){
    
    a[i][k]=6;
    }
      LinearPainting(i,j,i,c);
    }
     if (temp==temp2&temp2!=a[i][j]&j<c){
     
     
       System.out.println("Horizintal Choose "+i+","+j+" To "+i+","+c); 
    for(int k=j;k<=c;k++){
     
           
       a[i][k]=6;
    }
   
     
        LinearPainting(i,j,i,c);
    
        
        
        
        
        
    }
 if (temp<temp2){
     boolean dis=false;
     
       System.out.println("vertical  Painting from "+i+","+j+" To "+r+","+j); 
    for(int k=i;k<=r;k++){
       
             
    a[k][j]=7;
    }
    if (!dis){
      LinearPainting(i,j,r,j);
    }
    } 
 }
 }
  
  
    
    return a;
    }
   public static void LinearTempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterLinearPainting.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),false);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        
          for(int x=0;x<row;x++ ){
         
      for (int y=0;y<col;y++){
           
            bufferWritter.write(" "+a[x][y]);
           
      }
      bufferWritter.newLine();
      }
        
       bufferWritter.close();
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
     public static void LinearPainting( int i1 ,int j1,int i2,int j2) throws FileNotFoundException{
    try{
       
        	File file =new File("FinalLinearComends.txt");
                if(!file.exists()){
    			file.createNewFile();}
                  String commend="PAINT_LINE "+" "+i1+" "+j1+"  "+ i2+" "+j2;
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
              
    	        bufferWritter.write(commend);
               
                
                bufferWritter.newLine();
    	        bufferWritter.close();
    	    
	    total=total+1;
totalCommend[total]=commend;
                
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
     public static int [][] ZerosquerCheck(int a[][]) throws FileNotFoundException
     {
       for(int x=0;x<row;x++ ){
         
      for (int y=0;y<col;y++){
     if (a[x][y]==1){
         
         a[x][y]=8;
        SquarePainting(x,y,0);
         
     }}
     }

   return a;
}
       public static void ZeroSqaureTempPicOutput( int a[][]) throws FileNotFoundException{
    try{
       File file =new File("TempPicAfterZeroSquarePainting.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),false);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        
          for(int x=0;x<row;x++ ){
         
      for (int y=0;y<col;y++){
           
            bufferWritter.write(" "+a[x][y]);
           
      }
      bufferWritter.newLine();
      }
        
       bufferWritter.close();
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
    
    }
       public static void outputfile(){
          
       total=total+1;
           
       System.out.println("this is toaral"+total);
         try{
       File file =new File(name+"Output.txt");
                if(!file.exists()){
    			file.createNewFile();}
                        FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
          bufferWritter.write(""+total);
           bufferWritter.newLine();
          for(int x=0;x<total;x++ ){
         
  
           
            bufferWritter.write(totalCommend[x]);
              bufferWritter.newLine();
      
   
      }
        
       bufferWritter.close();
	      //  System.out.println("Done");
    		}
     
   
      catch (IOException x) {
    System.err.format("IOException: %s%n", x);
    
    
    }
         
         
       
       }


public static int [][] eraseing(int a[][]){
        for (int i =0;i<row;i++){

for (int j=0;j<col;j++){
if (a[i][j]==3){
    a[i][j]=0;
 String commend ="ERASE_CELL "+" "+i+" "+j;
  total=total+1;
totalCommend[total]=commend;
                
}

}
}

return a;
}
}