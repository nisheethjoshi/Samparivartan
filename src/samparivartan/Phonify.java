/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package samparivartan;

/**
 *
 * @author nisheeth
 */
import  java.awt.*;
import  javax.swing.*;
import java.io.*;
class Phonify
{
String syl[] =new  String[20];   //to strore phonified strings
String trans = new String();
 int j=0;
String match=new String();

    public String phonify(String lastWord)
    {
        int i=0;
       j=0;
       int f=0;
       int flag=0;
       int tflag=0;
       System.out.println("Phonified Strings");
       match=lastWord;
     //------------------------------------first letter=vowel-----------------------------------------------------
       switch(match.charAt(i))   //switch1
      {

             case 'a' : if(i<match.length()-2)
                              {

                   if((match.charAt(i+1)=='n')&&  (!isVowel(match.charAt(i+2)) )&&(isConso(match.charAt(i+2)) ))
	           {
	 	flag=1;
		syl[j]=  new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1)));
		i=i+2;
		System.out.println(syl[j]);
		j=j+1;

                              }
                       }
 //----------------------------------------------------------------------------------------------------------------
             case 'e' :
             case 'i':
             case 'o':
             case 'u':
                           if(i<match.length()-2)
                             {
	          if((flag==0) && (!isVowel(match.charAt(i+1))))
                           {
                              syl[j]=new String(String.valueOf( match.charAt(i)));
                               i=i+1;
                            System.out.println(syl[j]);


     //----------------------------second letter vowel------------------------------------------------------------------------
                              switch(match.charAt(i)  )
                               {
                                 case  'a' :
                                 case 'e' :
                                 case 'i':
                                 case 'o':
                                 case 'u':


                                             syl[j]+=match.charAt(i);
                                              System.out.println(syl[j]);
                                              i=i+2;
                                               j++;
                                               break;
                                  default:// i++;
                                               j++;
                                              break;
                                }
       //--------------------------------------------------------------------------------------------------------------------
                       }   //if flag=0 ends
                    }
            default:
 //-----------------------------------------case : tta,ttha,dda,ddha,ssa----------------------------------------------------------------------------------------
                       while(i<=match.length()-2)
                       {   flag=0;
            if (match.charAt(i+1)=='x')
            {
              syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1));
                System.out.println(syl[j]);
                j++;
                i=i+2;


           }
                else  if((i<=match.length()-3)&&(match.charAt(i+1)=='h')&&(match.charAt(i+2)=='x'))
            {
              syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2));
                System.out.println(syl[j]);
                j++;
                i=i+3;


           }
              else if ((i<=match.length()-3) && ((match.charAt(i)==match.charAt(i+1) )&& (match.charAt(i+2)=='x')))

                {
                      syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2));
                System.out.println(syl[j]);
                j++;
                i=i+3;
           }

              else if( (i<=match.length()-4) && (match.charAt(i)==match.charAt(i+1) )&& (match.charAt(i+2)=='h')   && (match.charAt(i+3)=='x')    )

                {
                      syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2))+String.valueOf(match.charAt(i+3));
                System.out.println(syl[j]);
                j++;
                i=i+3;
           }



         else
          {

switch(match.charAt(i))
{

case 't' :
case 'd' :
case 'n'  :
case 's' :

          if(i<match.length()-2)

           {

         if(match.charAt(i)==match.charAt(i+1))
             {
                         switch(match.charAt(i+2))
                          {
                       case 'a' :
		case 'e' :
		case 'i'  :
		case 'o' :
	           case 'u' :
                       case'h':
                       syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2));
                                  i=i+3;

                               if(i<=match.length()-1)
                               {
                              switch(match.charAt(i))
                              {
                                             case 'a' :
		           case 'e' :
		           case 'i'  :
		          case 'o' :
	                            case 'u' :
                                       syl[j]+=match.charAt(i);
                                        tflag=1;
                                        i++;

                              }




                            } System.out.println(syl[j]);
                                      j++;
                                      break;

                       }
                        }
                            }
                             }



//--------------------------------------------ksh-----------------------------------------------------------



	if((i<=(match.length()-3))&&(match.charAt(i)=='k')&&(match.charAt(i+1)=='s')&&(match.charAt(i+2)=='h'))
                                   {
                        if(i<=(match.length()-4))
                        {
		  switch(match.charAt(i+3))
               		  {
		     case 'a' :
		     case 'e' :
                            case 'i'  :
		     case 'o' :
                            case 'u' :
			syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2))+String.valueOf(match.charAt(i+3)));
			i=i+4;
                                  if(i<=(match.length()-1))
                                   {
		               switch(match.charAt(i))
               		  {
		     case 'a' :
		     case 'e' :
                            case 'i'  :
		     case 'o' :
                           case 'u' :
			syl[j]+= String.valueOf(match.charAt(i));
                                   i++;
			}
                               }

                              System.out.println(syl[j]);
			j++;
			break;

                                }
		}
                      else
                      {
                               syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2)));
			i=i+3;
			System.out.println(syl[j]);
			j++;
     	            }


                    }
//-----------------------------------------------------gya--------------------------------------------------
                 if((i<=(match.length()-2))&&(match.charAt(i)=='g')&&(match.charAt(i+1)=='y'))
                                   {
                        if(i<=(match.length()-3))
                        {
		  switch(match.charAt(i+2))
               		  {
		     case 'a' :
		     case 'e' :
                		     case 'i'  :
		     case 'o' :
                		     case 'u' :
			syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2)));
			i=i+3;
                                   if(i<=(match.length()-1))
                                   {
		               switch(match.charAt(i))
               		  {
		     case 'a' :
		     case 'e' :
                            case 'i'  :
		     case 'o' :
                           case 'u' :
			syl[j]+= String.valueOf(match.charAt(i));
                                   i++;
			}
                               }
			System.out.println(syl[j]);
			j++;
			break;

                                }
		}
                      else
                      {
                               syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1)));
			i=i+2;
			System.out.println(syl[j]);
			j++;
     	            }


                    }


                      if((i<=(match.length()-3))&&(match.charAt(i+1)=='r'))
                                   {
                                     switch(match.charAt(i+2))
               		  {
		     	case 'a' :
		     	case 'e' :
                            	case 'i'  :
		     	case 'o' :
                           	case 'u' :
                                   syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2)));
			i=i+3;

		          if(i<=(match.length()-1))
                                   {
		               switch(match.charAt(i))
               		  {
		     case 'a' :
		     case 'e' :
                            case 'i'  :
		     case 'o' :
                           case 'u' :
			syl[j]+= String.valueOf(match.charAt(i));
                                   i++;
			}

			System.out.println(syl[j]);
			j++;


		           }
                                   else
                                 {


			System.out.println(syl[j]);
			j++;
     	                      }
                                   }

                               }


 //--------------------------------------1.-consonant + vowel-------------------------------------------------------
                          if(i<=match.length()-2)
	        {
	             switch(match.charAt(i+1))
                                {
                                case 'a' : if((i<=match.length()-3)&&(match.charAt(i+2)=='n')&&((i<=match.length()-4) &&(isConso(match.charAt(i+3)))))
                                             {

	 			flag=1;
				syl[j]=  new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1))+String.valueOf(match.charAt(i+2)));
				i=i+3;
				System.out.println(syl[j]);


                             		 }


                                case 'e' :
                                 case 'i':
                                case 'o':
                                 case 'u':
                                 case 'h':
                                                 if(flag==0)      //not "an" case
                                                   {
                                                      syl[j]=new String(String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1)));

                                                      i=i+2;
                                                      if(i<=match.length()-1)
                                        	  {
//----------------------------------------------------------2--- cosonant + 2 vowel-----------------------
			          switch(match.charAt(i))
                                               	          {
                                              	  	case  'a' :
                                                                                         if((i<=match.length()-2)&&(match.charAt(i+1)=='n')&&((i<=match.length()-3) &&(isConso(match.charAt(i+2)))))
                                                                                         {
                                                                                              flag=1;
                                   				     syl[j]+= String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1));
			                  	     i=i+2;

				         	}
                                               	 	case 'e' :
			 	case 'i' :
                                               	 	case 'o':
                                               	 	case 'u':

                                                      		if(flag==0)
                                                                                       {
                                                                                      syl[j]+=match.charAt(i);
					i++;
                                                            		}


//-----------------------------------------3.----------cosonant + 3 vowel- :ha:---------------------- ---------
                                                                        if(i<=match.length()-1)
                                                                                     switch(match.charAt(i))
                                                                                       {
 					case 'a' :
					case 'e' :
					case 'i'  :
					case 'o' :
					case 'u' :

				                                	syl[j]+=match.charAt(i);

                                             	                                                  f=1;

                                                                                        }
   //------------------------------ -------4.--         consonant + hh-------------------------------------------------------------------------------







                                              default:
                                                                if((match.charAt(i-1)=='h')&&(match.charAt(i)=='h'))
                                                                {
                                                                       syl[j]+=match.charAt(i);
				i++;

                                             	                    if(i<=match.length()-1)
                                                                         {
                                                                              switch(match.charAt(i))    //   "chha" switch
                                                                               {
 					case 'a' :
					case 'e' :
					case 'i'  :
					case 'o' :
					case 'u' :

				                                	syl[j]+=match.charAt(i);

                                             	                                                      i=i+1;

                                                                               }  // " chha" switch ends
//-----------------------------------------------------------------------------------------------------------------------
 				} //if ends


                                                               }  //  if hh ends
                                                    if((match.charAt(i-1)=='h')&&(match.charAt(i)=='r'))
                                                                {
                                                                       syl[j]+=match.charAt(i);
				i++;

                                             	                    if(i<=match.length()-1)
                                                                         {
                                                                              switch(match.charAt(i))    //   "shri" switch
                                                                               {
 					case 'a' :
					case 'e' :
					case 'i'  :
					case 'o' :
					case 'u' :

				                                	syl[j]+=match.charAt(i);

                                             	                                                      i=i+1;

                                                                               }  // " shri" switch ends
//-----------------------------------------------------------------------------------------------------------------------
 				} //if ends
                                                                       	i=i+4;



                                                               }  //  if shr ends

                                                      if (f==1)
                                                         i=i+1;
                                               }      //  switch ------consonant + 2 vowel ends
                                       }//if flag=0 ends
			System.out.println(syl[j]);
			     j++;

                                                } //switch consonant +vowel ends

                                         break;

                                   default:



                                              if((match.charAt(i)=='t')&&(match.charAt(i+1)=='r'))
                                                                {
                                                                       syl[j]=String.valueOf(match.charAt(i))+String.valueOf(match.charAt(i+1));
				i=i+2;

                                             	                    if(i<=match.length()-1)
                                                                         {
                                                                              switch(match.charAt(i))    //   "tri" switch
                                                                               {
 					case 'a' :
					case 'e' :
					case 'i'  :
					case 'o' :
					case 'u' :

				                                	syl[j]+=match.charAt(i);

                                             	                                                      i=i+1;

                                                                                                    tflag=1;
                                                                               }  // " tra"  ends

                                                                          } // match if ends
                                                                 } //tr if ends
                                              if(tflag==0)
                                               {
                                             syl[j]= String.valueOf(match.charAt(i));
                                              i=i+1;

                                              }

                                             System.out.println(syl[j]);


                                                j=j+1;
                                  }
                                }// while ends

                         }//switch1 ends
       }
                          if(i==match.length()-1)
                          {
                            syl[j]=String.valueOf(match.charAt(match.length()-1));
                               System.out.println(syl[j]);
                             j++;
                         }
         break;

         } //first switch ends



  String tra=matching();

  return tra;

 }


//----------------------------------------------------------------------------------------------------------------------------
boolean isVowel(char v)
 { if ((v =='a') || (v == 'e') || (v =='i') || (v == 'o') ||(v == 'u'))
    return true;
   else
  return false;
}

boolean isConso(int v)
 {
    int f=0;
    switch(v)
{
   case 'b' :
   case 'c' :
      case 'd' : case 'h' : case 'f' : case 'g' : case 'j' : case 'k' : case 'l' : case 'm' : case 'n' : case 'p' : case 'q' : case 'r' : case 's' : case 't' : case 'v' : case 'w' : case 'x' : case 'y' : case 'z' :

                        f=1;

}
   if (f==1)
    return true;
   else
  return false;
}//class ends
//-------------------------------------------------------------------------------------------------------------------------






///////////////////////////////////////// Unicode

String ch[]={
"\u0923\u094D",
"\u0915\u094D",
"\u0916\u094D",
"\u0917\u094D",
"\u0918\u094D",
"\u091A\u094D",
"\u091B\u094D",
"\u091C\u094D",
"\u091D\u094D",
"\u091F\u094D",
"\u0920\u094D",
"\u0921\u094D",
"\u0922\u094D",

"\u0924\u094D",
"\u0925\u094D",
"\u0926\u094D",
"\u0927\u094D",
"\u0928\u094D",
"\u092A\u094D",
"\u092B\u094D",
"\u092C\u094D",
"\u092D\u094D",
"\u092E\u094D",
"\u092F\u094D",
"\u0930\u094D",
"\u0932\u094D",
"\u0935\u094D",
"\u0936\u094D",
"\u0937\u094D",
"\u0938\u094D",
"\u0939\u094D",


"\u0905",
"\u0906",
"\u0907",
"\u0908",
"\u0909",
"\u090A",
"\u090B",
"\u090F",
"\u0910",
"\u0913",
"\u0914" ,
"\u0950 ",
"\u0905\u0902",


"\u0915",
 "\u0915",
"\u0915\u093E",
"\u0915\u093F",
"\u0915\u0940",
"\u0915\u0941",
"\u0915\u0942",
"\u0915\u0947",
"\u0915\u0948",
"\u0915\u0902",
"\u0915\u094B",
"\u0915\u094C",
"\u0915\u093E\u0902",

"\u0916",
"\u0916",
"\u0916\u093E",
"\u0916\u093F",
"\u0916\u0940",
"\u0916\u0941",
"\u0916\u0942",
"\u0916\u0947",
"\u0916\u0948",
"\u0916\u0902",
"\u0916\u094B",
"\u0916\u094C",

"\u0917",
"\u0917",
"\u0917\u093E",
"\u0917\u093F",
"\u0917\u0940",
"\u0917\u0941",
"\u0917\u0942",
"\u0917\u0947",
"\u0917\u0948",
"\u0917\u0902",
"\u0917\u094B",
"\u0917\u094C",
"\u0917\u093E\u0902",


"\u0918",
"\u0918",
"\u0918\u093E",
"\u0918\u093F",
"\u0918\u0940",
"\u0918\u0941",
"\u0918\u0942",
"\u0918\u0947",
"\u0918\u0948",
"\u0918\u0902",
"\u0918\u094B",
"\u0918\u094C",

"\u091A",
"\u091A",
"\u091A\u093E",
"\u091A\u093F",
"\u091A\u0940",
"\u091A\u0941",
"\u091A\u0942",
"\u091A\u0947",
"\u091A\u0948",
"\u091A\u0902",
"\u091A\u094B",
"\u091A\u094C",

"\u091B",
"\u091B",
"\u091B\u093E",
"\u091B\u093F",
"\u091B\u0940",
"\u091B\u0941",
"\u091B\u0942",
"\u091B\u0947",
"\u091B\u0948",
"\u091B\u0902",
"\u091B\u094B",
"\u091B\u094C",

"\u091C",
"\u091C",
"\u091C",
"\u091C",
"\u091C\u093E",
"\u091C\u093E",
"\u091C\u093F",
"\u091C\u093F",
"\u091C\u0940",
"\u091C\u0940",
"\u091C\u0941",
"\u091C\u0941",
"\u091C\u0942",
"\u091C\u0942",
"\u091C\u0947",
"\u091C\u0947",
"\u091C\u0948",
"\u091C\u0948",
"\u091C\u0902",
"\u091C\u0902",
"\u091C\u094B",
"\u091C\u094B",
"\u091C\u094C",
"\u091C\u094C",
"\u091C\u093E\u0902",


"\u091D",
"\u091D",
"\u091D\u093E",
"\u091D\u093F",
"\u091D\u0940",
"\u091D\u0941",
"\u091D\u0942",
"\u091D\u0947",
"\u091D\u0948",
"\u091D\u0902",
"\u091D\u094B",
"\u091D\u094C",


"\u091F",
"\u091F\u093E",
"\u091F\u093F",
"\u091F\u0940",
"\u091F\u0941",
"\u091F\u0942",
"\u091F\u0947",
"\u091F\u0948",
"\u091F\u0902",
"\u091F\u094B",
"\u091F\u094C",
"\u091F\u093E\u0902",


"\u0920",
"\u0920\u093E",
"\u0920\u093F",
"\u0920\u0940",
"\u0920\u0941",
"\u0920\u0942",
"\u0920\u0947",
"\u0920\u0948",
"\u0920\u0902",
"\u0920\u094B",
"\u0920\u094C",

"\u0921",
"\u0921\u093E",
"\u0921\u093F",
"\u0921\u0940",
"\u0921\u0941",
"\u0921\u0942",
"\u0921\u0947",
"\u0921\u0948",
"\u0921\u0902",
"\u0921\u094B",
"\u0921\u094C",

"\u0922",
"\u0922\u093E",
"\u0922\u093F",
"\u0922\u0940",
"\u0922\u0941",
"\u0922\u0942",
"\u0922\u0947",
"\u0922\u0948",
"\u0922\u0902",
"\u0922\u094B",
"\u0922\u094C",

"\u0923",
"\u0923\u093E",
"\u0923\u093F",
"\u0923\u0940",
"\u0923\u0941",
"\u0923\u0942",
"\u0923\u0947",
"\u0923\u0948",
"\u0923\u0902",
"\u0923\u094B",
"\u0923\u094C",

"\u0924",
"\u0924",
"\u0924\u093E",
"\u0924\u093F",
"\u0924\u0940",
"\u0924\u0941",
"\u0924\u0942",
"\u0924\u0947",
"\u0924\u0948",
"\u0924\u0902",
"\u0924\u094B",
"\u0924\u094C",
"\u0924\u093E\u0902",


"\u0925",
"\u0925",
"\u0925\u093E",
"\u0925\u093F",
"\u0925\u0940",
"\u0925\u0941",
"\u0925\u0942",
"\u0925\u0947",
"\u0925\u0948",
"\u0925\u0902",
"\u0925\u094B",
"\u0925\u094C",

"\u0926",
"\u0926",
"\u0926\u093E",
"\u0926\u093F",
"\u0926\u0940",
"\u0926\u0941",
"\u0926\u0942",
"\u0926\u0947",
"\u0926\u0948",
"\u0926\u0902",
"\u0926\u094B",
"\u0926\u094C",
"\u0926\u093E\u0902",


"\u0927",
"\u0927",
"\u0927\u093E",
"\u0927\u093F",
"\u0927\u0940",
"\u0927\u0941",
"\u0927\u0942",
"\u0927\u0947",
"\u0927\u0948",
"\u0927\u0902",
"\u0927\u094B",
"\u0927\u094C",


"\u0928",
"\u0928",
"\u0928\u093E",
"\u0928\u093F",
"\u0928\u0940",
"\u0928\u0941",
"\u0928\u0942",
"\u0928\u0947",
"\u0928\u0948",
"\u0928\u0902",
"\u0928\u094B",
"\u0928\u094C",


"\u092A",
"\u092A",
"\u092A\u093E",
"\u092A\u093F",
"\u092A\u0940",
"\u092A\u0941",
"\u092A\u0942",
"\u092A\u0947",
"\u092A\u0948",
"\u092A\u0902",
"\u092A\u094B",
"\u092A\u094C",
"\u092A\u093E\u0902",




"\u092B",
"\u092B",
"\u092B",
"\u092B\u093E",
"\u092B\u093E",
"\u092B\u093F",
"\u092B\u093F",
"\u092B\u0940",
"\u092B\u0940",
"\u092B\u0941",
"\u092B\u0941",
"\u092B\u0942",
"\u092B\u0942",
"\u092B\u0947",
"\u092B\u0947",
"\u092B\u0948",
"\u092B\u0948",
"\u092B\u0902",
"\u092B\u0902",
"\u092B\u094B",
"\u092B\u094B",
"\u092B\u094C",
"\u092B\u094C",
"\u092B\u093E\u0902",


"\u092C",
"\u092C",
"\u092C\u093E",
"\u092C\u093F",
"\u092C\u0940",
"\u092C\u0941",
"\u092C\u0942",
"\u092C\u0947",
"\u092C\u0948",
"\u092C\u0902",
"\u092C\u094B",
"\u092C\u094C",
"\u092C\u093E\u0902",



"\u092D",
"\u092D",
"\u092D\u093E",
"\u092D\u093F",
"\u092D\u0940",
"\u092D\u0941",
"\u092D\u0942",
"\u092D\u0947",
"\u092D\u0948",
"\u092D\u0902",
"\u092D\u094B",
"\u092D\u094C",

"\u092E",
"\u092E",
"\u092E\u093E",
"\u092E\u093F",
"\u092E\u0940",
"\u092E\u0941",
"\u092E\u0942",
"\u092E\u0947",
"\u092E\u0948",
"\u092E\u0902",
"\u092E\u094B",
"\u092E\u094C",
"\u092E\u093E\u0902",


"\u092F",
"\u092F",
"\u092F\u093E",
"\u092F\u093F",
"\u092F\u0940",
"\u092F\u0941",
"\u092F\u0942",
"\u092F\u0947",
"\u092F\u0948",
"\u092F\u0902",
"\u092F\u094B",
"\u092F\u094C",
"\u092F\u093E\u0902",


"\u0930",
"\u0930",
"\u0930\u093E",
"\u0930\u093F",
"\u0930\u0940",
"\u0930\u0941",
"\u0930\u0942",
"\u0930\u0947",
"\u0930\u0948",
"\u0930\u0902",
"\u0930\u094B",
"\u0930\u094C",
"\u0930\u093E\u0902",


"\u0932",
"\u0932",
"\u0932\u093E",
"\u0932\u093F",
"\u0932\u0940",
"\u0932\u0941",
"\u0932\u0942",
"\u0932\u0947",
"\u0932\u0948",
"\u0932\u0902",
"\u0932\u094B",
"\u0932\u094C",
"\u0932\u093E\u0902",



"\u0935",
"\u0935",
"\u0935",
"\u0935",
"\u0935\u093E",
"\u0935\u093E",
"\u0935\u093F",
"\u0935\u093F",
"\u0935\u0940",
"\u0935\u0940",
"\u0935\u0941",
"\u0935\u0941",
"\u0935\u0942",
"\u0935\u0942",
"\u0935\u0947",
"\u0935\u0947",
"\u0935\u0948",
"\u0935\u0948",
"\u0935\u0902",
"\u0935\u0902",
"\u0935\u093E\u0902",
"\u0935\u093E\u0902",
"\u0935\u094B",
"\u0935\u094B",
"\u0935\u094B",
"\u0935\u094B",

"\u0936",
"\u0936",
"\u0936\u093E",
"\u0936\u093F",
"\u0936\u0940",
"\u0936\u0941",
"\u0936\u0942",
"\u0936\u0947",
"\u0936\u0948",
"\u0936\u0902",
"\u0936\u093E\u0902",
"\u0936\u094B",
"\u0936\u094C",


"\u0937",
"\u0937\u093E",
"\u0937\u093F",
"\u0937\u0940",
"\u0937\u0941",
"\u0937\u0942",
"\u0937\u0947",
"\u0937\u0948",
"\u0937\u0902",
"\u0937\u093E\u0902",
"\u0937\u094B",
"\u0937\u094C",


"\u0938",
"\u0938",
"\u0938\u093E",
"\u0938\u093F",
"\u0938\u0940",
"\u0938\u0941",
"\u0938\u0942",
"\u0938\u0947",
"\u0938\u0948",
"\u0938\u0902",
"\u0938\u093E\u0902",
"\u0938\u094B",
"\u0938\u094C",

"\u0939",
"\u0939",
"\u0939\u093E",
"\u0939\u093F",
"\u0939\u0940",
"\u0939\u0941",
"\u0939\u0942",
"\u0939\u0947",
"\u0939\u0948",
"\u0939\u0902",
"\u0939\u093E\u0902",
"\u0939\u094B",
"\u0939\u094C",

"\u0915\u094D\u0937",                    //ksh
"\u0915\u094D\u0937",
"\u0915\u094D\u0937\u093E",
"\u0915\u094D\u0937\u093F",
"\u0915\u094D\u0937\u0940",
"\u0915\u094D\u0937\u0941",
"\u0915\u094D\u0937\u0942",
"\u0915\u094D\u0937\u0947",
"\u0915\u094D\u0937\u0948",
"\u0915\u094D\u0937\u0902",
"\u0915\u094D\u0937\u093E\u0902",
"\u0915\u094D\u0937\u094B",
"\u0915\u094D\u0937\u094C",



"\u092A\u094D\u0930",             //pra
"\u092A\u094D\u0930",
"\u092A\u094D\u0930\u093E",
"\u092A\u0943",
"\u092A\u094D\u0930\u093F",
"\u092A\u094D\u0930\u0940",
"\u092A\u094D\u0930\u0941",
"\u092A\u094D\u0930\u0942",
"\u092A\u094D\u0930\u0947",
"\u092A\u094D\u0930\u0948",
"\u092A\u094D\u0930\u0902",
"\u092A\u094D\u0930\u093E\u0902",
"\u092A\u094D\u0930\u094B",
"\u092A\u094D\u0930\u094C",


"\u091C\u094D\u091E",                 //gya
"\u091C\u094D\u091E",
"\u091C\u094D\u091E\u093E",
"\u091C\u094D\u091E\u093F",
"\u091C\u094D\u091E\u0940",
"\u091C\u094D\u091E\u0941",
"\u091C\u094D\u091E\u0942",
"\u091C\u094D\u091E\u0947",
"\u091C\u094D\u091E\u0948",
"\u091C\u094D\u091E\u0902",
"\u091C\u094D\u091E\u094B",
"\u091C\u094D\u091E\u094C",

"\u0924\u094D\u0930",
"\u0924\u094D\u0930",
"\u0924\u094D\u0930\u093E",
"\u0924\u094D\u0930\u093F",
"\u0924\u094D\u0930\u0940",
"\u0924\u094D\u0930\u0941",
"\u0924\u094D\u0930\u0942",
"\u0924\u094D\u0930\u0947",
"\u0924\u094D\u0930\u0948",
"\u0924\u094D\u0930\u0902",
"\u0924\u094D\u0930\u094B",
"\u0924\u094D\u0930\u094C",


"\u0966",
"\u0967",
"\u0968",
"\u0969",
"\u096A",
"\u096B",
"\u096C",
"\u096D",
"\u096E",
"\u096F",



"\u0915\u094D\u0930",             //kra
"\u0915\u094D\u0930",
"\u0915\u094D\u0930\u093E",
"\u0915\u0943",
"\u0915\u094D\u0930\u093F",
"\u0915\u094D\u0930\u0940",
"\u0915\u094D\u0930\u0941",
"\u0915\u094D\u0930\u0942",
"\u0915\u094D\u0930\u0947",
"\u0915\u094D\u0930\u0948",
"\u0915\u094D\u0930\u0902",
"\u0915\u094D\u0930\u093E\u0902",
"\u0915\u094D\u0930\u094B",
"\u0915\u094D\u0930\u094C",


"\u0917\u094D\u0930",             //gra
"\u0917\u094D\u0930",
"\u0917\u094D\u0930\u093E",
"\u0917\u0943",
"\u0917\u094D\u0930\u0940",
"\u0917\u094D\u0930\u0941",
"\u0917\u094D\u0930\u0942",
"\u0917\u094D\u0930\u0947",
"\u0917\u094D\u0930\u0948",
"\u0917\u094D\u0930\u0902",
"\u0917\u094D\u0930\u093E\u0902",
"\u0915\u094D\u0930\u094B",
"\u0915\u094D\u0930\u094C",

"\u0926\u094D\u0930",             //dra
"\u0926\u094D\u0930",
"\u0926\u094D\u0930\u093E",
"\u0926\u0943",
"\u0926\u094D\u0930\u0940",
"\u0926\u094D\u0930\u0941",
"\u0926\u094D\u0930\u0942",
"\u0926\u094D\u0930\u0947",
"\u0926\u094D\u0930\u0948",
"\u0926\u094D\u0930\u0902",
"\u0926\u094D\u0930\u093E\u0902",
"\u0926\u094D\u0930\u094B",
"\u0926\u094D\u0930\u094C",


"\u0927\u094D\u0930",             //dhra
"\u0927\u094D\u0930",
"\u0927\u094D\u0930\u093E",
"\u0927\u0943",
"\u0927\u094D\u0930\u0940",
"\u0927\u094D\u0930\u0941",
"\u0927\u094D\u0930\u0942",
"\u0927\u094D\u0930\u0947",
"\u0927\u094D\u0930\u0948",
"\u0927\u094D\u0930\u0902",
"\u0927\u094D\u0930\u093E\u0902",
"\u0927\u094D\u0930\u094B",
"\u0927\u094D\u0930\u094C",


"\u092C\u094D\u0930",             //BR
"\u092C\u094D\u0930",
"\u092C\u094D\u0930\u093E",
"\u092C\u0943",
"\u092C\u094D\u0930\u0940",
"\u092C\u094D\u0930\u0941",
"\u092C\u094D\u0930\u0942",
"\u092C\u094D\u0930\u0947",
"\u092C\u094D\u0930\u0948",
"\u092C\u094D\u0930\u0902",
"\u092C\u094D\u0930\u093E\u0902",
"\u092C\u094D\u0930\u094B",
"\u092C\u094D\u0930\u094C",

"\u092D\u094D\u0930",             //BHR
"\u092D\u094D\u0930",
"\u092D\u094D\u0930\u093E",
"\u092D\u0943",
"\u092D\u094D\u0930\u0940",
"\u092D\u094D\u0930\u0941",
"\u092D\u094D\u0930\u0942",
"\u092D\u094D\u0930\u0947",
"\u092D\u094D\u0930\u0948",
"\u092D\u094D\u0930\u0902",
"\u092D\u094D\u0930\u093E\u0902",
"\u092D\u094D\u0930\u094B",
"\u092D\u094D\u0930\u094C",

"\u092E\u094D\u0930",             //MR
"\u092E\u094D\u0930",
"\u092E\u094D\u0930\u093E",
"\u092E\u0943",
"\u092E\u094D\u0930\u0940",
"\u092E\u094D\u0930\u0941",
"\u092E\u094D\u0930\u0942",
"\u092E\u094D\u0930\u0947",
"\u092E\u094D\u0930\u0948",
"\u092E\u094D\u0930\u0902",
"\u092E\u094D\u0930\u093E\u0902",
"\u092E\u094D\u0930\u094B",
"\u092E\u094D\u0930\u094C",

"\u0936\u094D\u0930",
"\u0936\u094D\u0930",
"\u0936\u094D\u0930\u093E",
"\u0936\u094D\u0930\u093F",
"\u0936\u094D\u0930\u0940",
"\u0936\u094D\u0930\u0941",
"\u0936\u094D\u0930\u0942",
"\u0936\u094D\u0930\u0947",
"\u0936\u094D\u0930\u0948",
"\u0936\u094D\u0930\u0902",
"\u0936\u094D\u0930\u094B",
"\u0936\u094D\u0930\u094C",


",",
";",
"."











 };



String ph[]=
{









"nnx",
"kx",
"khx",
"gx",
"ghx",
"cx",
"chhx",
"jx",
"jhx",
"ttx",
"tthx",
"ddx",
"ddhx",
"tx",
"thx",
"dx",
"dhx",
"nx",
"px",
"phx",
"bx",
"bhx",
"mx",
"yx",
"rx",
"lx",
"vx",
"shx",
"ssx",
"sx",
"hx",


"a",
"aa",
"i",
"ee",
"u",
"oo",
"rii",
"e",
"ai",
"o",
"au",
"om",
"an",


"k",
  "ka",
 "kaa",
"ki",
"kee",
"ku",
"koo",
"ke",
"kai",
"kan",
"ko",
"kau",
"kaan",


"kh",
"kha",
"khaa",
"khi",
"khee",
"khu",
"khoo",
"khe",
"khai",
"khan",
"kho",
"khau",


"g",
"ga",
"gaa",
"gi",
"gee",
"gu",
"goo",
"ge",
"gai",
"gan",
"go",
"gau",
"gaan",


"gh",
"gha",
"ghaa",
"ghi",
"ghee",
"ghu",
"ghoo",
"ghe",
"ghai",
"ghan",
"gho",
"ghau",


"ch",
"cha",
"chaa",
"chi",
"chee",
"chu",
"choo",
"che",
"chai",
"chan",
"cho",
"chau",

"chh",
"chha",
"chha",
"chhi",
"chhee",
"chhu",
"chhoo",
"chhe",
"chhai",
"chhan",
 "chho",
"chhau",


"z",
"j",
"za",
"ja",
"zaa",
"jaa",
"zi",
"ji",
"zee",
"jee",
"zu",
"ju",
"zoo",
"joo",
"ze",
"je",
"zai",
"jai",
"zan",
"jan",
"zo",
"jo",
"zau",
"jau",
"jaan",
"zaan",

"jh",
"jha",
"jhaa",
"jhi",
"jhee",
"jhu",
"jhoo",
"jhe",
"jhai",
"jhan",
"jho",
"jhau",

"tta",
"ttaa",
"tti",
"ttee",
"ttu",
"ttoo",
"tte",
"ttai",
"ttan",
"tto",
"ttau",

"ttha",
"tthaa",
"tthi",
"tthee",
"tthu",
"tthoo",
"tthe",
"tthai",
"tthan",
"ttho",
"tthau",

"dda",
"ddaa",
"ddi",
"ddee",
"ddu",
"ddoo",
"dde",
"ddai",
"ddan",
"ddo",
"ddau",

 "ddha",
"ddhaa",
"ddhi",
"ddhee",
"ddhu",
"ddhoo",
"ddhe",
"ddhai",
"ddhan",
"ddho",
"ddhau",


"nna",
"nnaa",
"nni",
"nnee",
"nnu",
"nnoo",
"nne",
"nnai",
"nnan",
"nno",
"nnau",




"t",
"ta",
"taa",
"ti",
"tee",
"tu",
"too",
"te",
"tai",
"tan",
"to",
"tau",
"taan",

"th",
"tha",
"thaa",
"thi",
"thee",
"thu",
"thoo",
"the",
"thai",
"than",
"tho",
"thau",

"d",
"da",
"daa",
"di",
"dee",
"du",
"doo",
"de",
"dai",
"dan",
"do",
"dau",
"daan",

"dh",
"dha",
"dhaa",
"dhi",
"dhee",
"dhu",
"dhoo",
"dhe",
"dhai",
"dhan",
"dho",
"dhau",

"n",
"na",
"naa",
"ni",
"nee",
"nu",
"noo",
"ne",
"nai",
"nan",
"no",
"nau",

"p",
"pa",
"paa",
"pi",
"pee",
"pu",
"poo",
"pe",
"pai",
"pan",
"po",
"pau",
"paan",

"f",
"fa",
"pha",
"faa",
"phaa",
"fi",
"phi",
"fee",
"phee",
"fu",
"phu",
"foo",
"phoo",
"fe",
"phe",
"fai",
"phai",
"fan",
"phan",
"fo",
"pho",
"fau",
"phau",
"faan",

"b",
"ba",
"baa",
"bi",
"bee",
"bu",
"boo",
"be",
"bai",
"ban",
"bo",
"bau",
"baan",

"bh",
"bha",
"bhaa",
"bhi",
"bhee",
"bhu",
"bhoo",
"bhe",
"bhai",
"bhan",
"bho",
"bhau",

"m",
"ma",
"maa",
"mi",
"mee",
"mu",
"moo",
"me",
"mai",
"man",
"mo",
"mau",
"maan",

"y",
"ya",
"yaa",
"yi",
"yee",
"yu",
"yoo",
"ye",
"yai",
"yan",
"yo",
"yau",
"yaan",

"r",
"ra",
"raa",
"ri",
"ree",
"ru",
"roo",
"re",
"rai",
"ran",
"ro",
"rau",
"raan",

"l",
"la",
"laa",
"li",
"lee",
"lu",
"loo",
"le",
"lai",
"lan",
"lo",
"lau",
"laan",

"w",
"v",
"va",
"wa",
"waa",
"vaa",
"wi",
"vi",
"vee",
"wee",
"vu",
"wu",
"voo",
"woo",
"ve",
"we",
"vai",
"wai",
"van",
"wan",
"vaan",
"waan",
"wo",
"vo",
"wau",
"vau",

"sh",
"sha",
"shaa",
"shi",
"shee",
"shu",
"shoo",
"she",
"shai",
"shan",
"shaan",
"sho",
"shau",


"ssa",
"ssaa",
"ssi",
"ssee",
"ssu",
"ssoo",
"sse",
"ssai",
"ssan",
"ssaan",
"sso",
"ssau",

"s",
"sa",
"saa",
"si",
"see",
"su",
"soo",
"se",
"sai",
"san",
"saan",
"so",
"sau",

"h",
"ha",
"haa",
"hi",
"hee",
"hu",
"hoo",
"he",
"hai",
"han",
"haan",
"ho",
"hau",

"ksh",
"ksha",
"kshaa",
"kshi",
"kshee",
"kshu",
"kshoo",
"kshe",
"kshai",
"kshan",
"kshaan",
"ksho",
"kshau",

"pr",
"pra",
"praa",
"pri",
"prii",
"pree",
"pru",
"proo",
"pre",
"prai",
"pran",
"praan",
"pro",
"prau",

"gy",
"gya",
"gyaa",
"gyi",
"gyee",
"gyu",
"gyoo",
"gye",
"gyai",
"gyan",
"gyo",
"gyau",


"tr",
"tra",
"traa",
"tri",
"tree",
"tru",
"troo",
"tre",
"trai",
"tran",
"tro",
"trau",

"0",
"1",
"2",
"3",
"4",
"5",
"6",
"7",
"8",
"9",


"kr",
"kra",
"kraa",
"kri",
"krii",
"kree",
"kru",
"kroo",
"kre",
"krai",
"kran",
"kraan",
"kro",
"krau",


"gr",
"gra",
"graa",
"gri",
"gree",
"gru",
"groo",
"gre",
"grai",
"gran",
"graan",
"gro",
"grau",

"dr",
"dra",
"draa",
"dri",
"dree",
"dru",
"droo",
"dre",
"drai",
"dran",
"draan",
"dro",
"drau",


"dhr",
"dhra",
"dhraa",
"dhri",
"dhree",
"dhru",
"dhroo",
"dhre",
"dhrai",
"dhran",
"dhraan",
"dhro",
"dhrau",

"br",
"bra",
"braa",
"bri",
"bree",
"bru",
"broo",
"bre",
"brai",
"bran",
"braan",
"bro",
"brau",



"bhr",
"bhra",
"bhraa",
"bhri",
"bhree",
"bhru",
"bhroo",
"bhre",
"bhrai",
"bhran",
"bhraan",
"bhro",
"bhrau",

"mr",
"mra",
"mraa",
"mri",
"mree",
"mru",
"mroo",
"mre",
"mrai",
"mran",
"mraan",
"mro",
"mrau",



"shr",
"shra",
"shraa",
"shri",
"shree",
"shru",
"shroo",
"shre",
"shrai",
"shran",
"shraan",
"shro",
"shrau",
",",

";",

"|"









};


















public String matching() throws NullPointerException
{


     String tr=new String();
   for(int p=0;p<j;p++)
   {
     for(int s=0;s<ph.length;s++)
    {
        if(syl[p].equalsIgnoreCase(ph[s]))
        {
              tr=tr+ch[s];

              break;
        }
     }
   }
     String t=tr;
      return t;
}
}
