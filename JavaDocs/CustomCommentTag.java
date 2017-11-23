/**
* @since       JDK1.0
 * @Alphabet.Features 
 *     <br>"A" 
 *     <br>"B" 
 *     <br>"C" 
 *     <br>"D"  
 * @Number.Features 
 * <b>summary</b>
 *     <br>"1"
 *     <br>"2"
 *     <br>"3"
 *     <br>"4"
 */


public class CustomCommentTag {
    public static void main(String[] args){
        System.out.println("Code executed");
    }
}



//run instructions
//javac CustomCommentTag.java
//javadoc -tag Alphabet.Features:a:"Metas of PE feature:" CustomTag.java
//javadoc -tag Number.Features:a:"Metas of MACO feature:" CustomTag.java
//javadoc -tag Alphabet.Features:a:"Metas of PE feature:" -tag Number.Features:a:"Metas of MACO feature:" CustomTag.java
