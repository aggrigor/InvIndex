
package invindex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.io.IOException;
import java.lang.String;
import java.util.Vector;


/**Inverted Index Project for I.R - uth
 *
 * @author Aggeliki Grigoropoulou
 * AEM : 699
 * 
 * Spring Semester 2014
 */
public class StrTokenizer
{
            private String path;
            private String fname;
            public String[] Array;
            public int[] docPosition;
            final int maxLength = 90000;
            public String str = "REUTERS";
            int i = 0;
            public int NoDocs ;
            Vector<Integer> vec = new Vector<Integer>(600);
            public Integer number;
            //Constructor
            public StrTokenizer()
            {       
                  NoDocs = 0;
                  path = "C:\\Documents and Settings\\Angie\\Επιφάνεια εργασίας\\reuters21578\\reut2-021.sgm";
                  fname =  path ;
            } 
            
            //Openfile method parses the data of a file and stores every word in an array
            public String[] Openfile() throws IOException
            {
                  Array = new String[maxLength];
                  
                  try
                  {
                        BufferedReader sr = new BufferedReader(new FileReader(fname));
                        StreamTokenizer tokens = new StreamTokenizer(sr);
                        boolean eof = false;
                                               
                        do
                        {                               
                                int tok = tokens.nextToken();
                                
                                tokens.ordinaryChar('"');
                                tokens.ordinaryChar('\\');
                                tokens.ordinaryChar('/');
                                tokens.ordinaryChar('.');
                                tokens.ordinaryChar('>');
                                tokens.ordinaryChar('-');
                                
                                switch (tok)
                                {
                                    case StreamTokenizer.TT_WORD:
                                        Array[i]= tokens.sval;
                                      //  System.out.println("Array "+ i +": "+ Array[i]);
                                        i++;
                                        continue;
                                    case StreamTokenizer.TT_NUMBER:
                                       // System.out.println("Number: " + tokens.nval);
                                        continue;
                                    case StreamTokenizer.TT_EOF:
                                       // System.out.println("End of File");
                                        eof = true;
                                        break;
                                    default:
                                        //specify delimiters
                                        if ((char)tok == ('<')) 
                                        {   
                                            do
                                            {   
                                                  tok = tokens.nextToken();
                                                  if ((char)tok=='/')
                                                  {
                                                      tok = tokens.nextToken();
                                                      if((tokens.sval).equals(str))
                                                      {
                                                           vec.addElement(new Integer(i));
                                                           //System.out.println("position: "+i);
                                                           NoDocs++;
                                                      }
                                                  }
                                               
                                                  
                                            }while((char)tok !='>');
                                            
                                        }
                                        else  if((char)tok == ('>')) 
                                        {                                               
                                        }
                                        else  if((char)tok == ('\\')) 
                                        {         
                                        }
                                        else  if((char)tok == (',')) 
                                        {                     
                                        }
                                        else  if((char)tok == (' ')) 
                                        {                                                
                                        }
                                        else  if((char)tok == ('\n')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('\t')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('{')) 
                                        {                                               
                                        }
                                        else  if((char)tok == ('}')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('(') )
                                        {                                             
                                        }
                                        else  if((char)tok == (')')) 
                                        {                                               
                                        }
                                        else  if((char)tok == ('_')) 
                                        {                                               
                                        }
                                        else  if((char)tok == ('-')) 
                                        {                                               
                                        }
                                        else  if((char)tok == ('/')) 
                                        {       
                                        }
                                        else  if((char)tok == ('?')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('.')) 
                                        {   
                                        }
                                        else  if((char)tok == ('!')) 
                                        {                                              
                                        }
                                        else  if((char)tok == (':')) 
                                        {                                               
                                        }
                                        else  if((char)tok == (';')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('[')) 
                                        {                                               
                                        }
                                        else  if((char)tok == (']')) 
                                        {                                             
                                        }
                                        else  if((char)tok == ('=')) 
                                        {                                            
                                        }
                                        else  if((char)tok == ('#')) 
                                        {                                              
                                        }
                                        else  if((char)tok == ('&')) 
                                        {                                               
                                        } 
                                        else  if((char)tok == ('"')) 
                                        {                                             
                                        } 
                                }                    
                        }
                        while(!eof);
                        sr.close();
                   }     
                   catch(IOException e)
                   {
                         System.out.println(e.getMessage());
                   }
                   catch (NumberFormatException e) {} 
                    
                   //print the array of terms
                   
                  /* for (i=0; i<maxLength; i++)
                   {    
                        System.out.println("Array "+ i +": "+ Array[i]);
                   }*/
                   //System.out.println("NoDocs: "+NoDocs);
                   
                   return Array;
            }    
            
            //method posArray returns the array with the positions of the documents in the file
            public Vector<Integer> posArray( )
            {
                 //  for (Integer number : vec)
                 //  {         
                 //      System.out.println("position = " + number);
                 //  }
                   return vec;
            }
            public int retNoDocs()
            {
                   return NoDocs;
            }
}

  //TODO create method to return NoDocs
               

