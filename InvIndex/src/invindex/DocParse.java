
package invindex;

import java.io.IOException;
import java.util.Vector;
import java.util.ArrayList;
import java.lang.String;

/**Inverted Index Project for I.R - uth
 *
 * @author Aggeliki Grigoropoulou
 * 
 * Spring Semester 2014
 */

public class DocParse extends StrTokenizer 
{
    int i;
    int j; 
    int k;
    int NoDocs;
    private String[] terms;
    Vector pos;
    ArrayList<String> doc ;
    ArrayList<ArrayList<String>> group;
    String st;
           
    //constructor
    public DocParse() 
    {
        try
        {  
                st = null;
                k = 0;
                i = 0;
                j = 0;
                NoDocs = 578;
                terms = super.Openfile(); 
                pos = super.posArray();
                group = new ArrayList<>(NoDocs);
                doc = new ArrayList<>(1000);
               
        }
        catch(IOException e)
        {
                System.out.println(e.getMessage());
        }
    }
    
    public ArrayList returnDocs(String[] terms)
    {
          //  terms = this.terms;
            
            do
            {
                        if (terms[i]==null)
                            break;
                        if (j == NoDocs)
                           break;
                        //convert uppercase to lowercase 
                        terms[i] = terms[i].toLowerCase();
                        //System.out.println("term " +i+ ": "+terms[i]);
                        if(i == (int)pos.get(j)-1)
                        {
                            //System.out.println("--------NEXT DOCUMENT----------");
                            group.add(doc);
                            doc = new ArrayList<>(1000);
                            j++;
                        }
                        else
                        {           
                            doc.add(terms[i]);                       
                        }
                        
                        i++;                  
            } while(i < maxLength);      
        return group;
    }
}

