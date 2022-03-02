import java.util.Scanner;
public class Cubic{
    public static void main(String arg[]){
      takeInput();
    }

    //input: x-intercepts of polynomial function
    //output: -(x-intercepts)
    public static int[] signSwap(int[] xinter){ //swap signs because ALGBREA
      int[] xs = new int[xinter.length];
      for(int i=0; i<xinter.length; i++){
        xs[i] = -(xinter[i]);
      }
      return xs;
    }

    //input: x to solve for and x-inters
    //output: y of polynomial function
    public static int solveForY(int x,int[] equation,int coeffient,int[] pow){
      int[] halfa = new int[equation.length]; //half answer not half ass
      int a = coeffient; //setting this to one should not effect anything since this is for *ing
      for(int i = 0; i< equation.length; i++){
        halfa[i] = (int) Math.pow((x+equation[i]),pow[i]); 
      }
      
      for(int i = 0; i<halfa.length; i++){
        a = halfa[i] * a;
      }
      return a;
    }

    //input: x-inters
    //output: scope or how big the graph should be 
    public static int graphScope(int[] xInter){ //THIS IS ONLY FOR AUTOMATIC SCOPE
      //don't need to abs the xinters for some reason?
      int start = 0; //might need to change this for only neg x-inters
      for(int i = 0; i < xInter.length; i++){
        for(int j = 0; j < xInter.length; j++){
          if(start < Math.abs(xInter[j])){
            start = Math.abs(xInter[j]);
          }
        }
      }
      start = start*2;
      return start;
    }
    
    //input: x-intercepts
    //output: orderpairs
    public static int[][] graphBuilder(int[] xinters,int coeffient,int pow[]){
      xinters = signSwap(xinters);
      int scope = graphScope(xinters); //USE DIFFRENT VARIABLE NAMES bc for some reason graphscope math.abs the xinters in this function
      int[][] graph = new int[scope*2+1][2]; //ordered pair x,y

      for(int i = scope; i > 0; i--){
          graph[scope-i][0] = -(i);
          graph[scope-i][1] = solveForY(-(i), xinters,coeffient,pow);
      }
      for(int j = scope; j< scope*2+1; j++){
        graph[j][0] = j-scope;
        graph[j][1] = solveForY(j-scope, xinters,coeffient,pow);
      }
      
      return graph;
    }
    
    //input: orderpairs
    //output: largest y in scope
    public static int relativeMax(int[][] orderedPairs){
      //find biggist y
      int biggist = 0;
      for(int i = 0; i < orderedPairs.length; i++){
        for(int j = 0; j < orderedPairs.length; j++){
          if(biggist < orderedPairs[j][1]){
            biggist = orderedPairs[j][1];
          }
        }
      }
      return biggist;
    }
    //input: ordered pairs
    //output: smallist y in scope
    public static int relativeMin(int[][] orderedPairs){
      //find smallist y
      int smallist = 0;
      for(int i = 0; i < orderedPairs.length; i++){
        for(int j = 0; j < orderedPairs.length; j++){
          if(smallist > orderedPairs[j][1]){
            smallist = orderedPairs[j][1];
          }
        }
      }
      return smallist;
    }
  
    //output: ordered pair and information about them
    //add try catch recursion to every question
    public static void takeInput(){
      Scanner scan = new Scanner(System.in);
      
      int LengthOfxs = 0;
      int[] xIntercepts = new int[0];
      int coeffient = 0;
      int[] pows = new int[0];

      //ask for amount of x-inters
      try{ //handling exceptions taken from https://rollbar.com/guides/java/how-to-handle-exceptions-in-java/#:~:text=The%20try%2Dcatch%20is%20the,simplest%20mechanism%20for%20handling%20exceptions.
        System.out.print("enter amount of x intercepts on graph: ");
        LengthOfxs =  scan.nextInt();
        xIntercepts = new int[LengthOfxs];
      } catch (Exception e) {
        System.out.println(e + " restarting program" + "\n");
        takeInput(); //finally a use for recursion
      }

      //ask for coeffient
      try {
        System.out.print("enter coeffient: ");
        coeffient = scan.nextInt();
      } catch (Exception e) {
        System.out.print(e + " restarting program" + "\n");
        takeInput();
      }

      //ask for x-inters
      try {
        System.out.print("enter x intercepts: ");
        for(int i = 0; i<LengthOfxs; i++){
          xIntercepts[i] = scan.nextInt();
        }
      } catch (Exception e) {
        System.out.print(e + " restarting program" + "\n");
        takeInput();
      }
      //ask for exponents
      try {
        System.out.print("enter power's: ");
        pows = new int[LengthOfxs];
        for(int i = 0; i<LengthOfxs; i++){
          System.out.print(xIntercepts[i] + " to the power of ");
          pows[i] = scan.nextInt();
        }
      } catch (Exception e) {
        System.out.print(e + " restarting program" + "\n");
        takeInput();
      }
      
      scan.close();
      
      //print
      int[][] orderedPairs = graphBuilder(xIntercepts,coeffient,pows);
      int maxOfScope = relativeMax(orderedPairs);
      int minOfScope = relativeMin(orderedPairs);
      System.out.println("printing ordered pairs: ");
      for(int i = 0; i<orderedPairs.length; i++){
        System.out.print("(" + (orderedPairs[i][0]) + ", ");
        System.out.print((orderedPairs[i][1]) + ")");
        if(maxOfScope == orderedPairs[i][1]){
          System.out.print("    <---- max y of scope");
        }if(minOfScope == orderedPairs[i][1]){
          System.out.print("    <---- min y of scope");
        }if( 0 == orderedPairs[i][1]){
          System.out.print("    <---- x-intercept");
        } if ( 0 == orderedPairs[i][0]){
          System.out.print("    <---- y-intercept");
        }
        System.out.print("\n");
      }
    }
  }