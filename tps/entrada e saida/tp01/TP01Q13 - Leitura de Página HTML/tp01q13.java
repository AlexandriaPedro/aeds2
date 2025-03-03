
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

/*
 * Leitura de Página HTML - Leia duas strings sendo que a 
 * primeira ́e o nome de uma página web e a segunda, seu 
 * endereço. Por exemplo, “Pontifícia Universidade Católica 
 * de Minas Gerais” e “www.pucminas.br”. Em seguida, mostre 
 * na tela o número de vogais (sem e com acento), consoantes 
 * e dos padrões “< br >” e “< table >” que aparecem no código 
 * dessa página. A entrada padrão ́e composta por várias linhas.
 * Cada uma contém várias strings sendo que a primeira é um endereço 
 * web e as demais o nome dessa página web. A  ́ultima linha da entrada 
 * padrão contém a palavra “FIM”. A saída padrão contém várias linhas 
 * sendo que cada uma apresenta o número de ocorrência (valor xi entre parênteses) 
 * de cada caractere ou string solicitado. Cada linha de saída será da seguinte forma: 
 * a(x1) e(x2) i(x3) o(x4) u(x5) ́a(x6) ́e(x7) ́ı(x8) ́o(x9) ́u(x10)
 * à(x11) è(x12) ì(x13) ò(x14) ù(x15) ̃a(x16) ̃o(x17) â(x19) ê(x19) î(x20) ô(x21) û(x22) 
 * consoante(x23) < br >(x24) < table >(x25) nomepágina(x26).
 */

public class tp01q13 {
    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
    }

    public static String htmlGeneralCounter (String sentenceOne, String sentenceTwo) {
        int aCounter = 0, eCounter = 0, iCounter = 0, oCounter = 0, uCounter = 0, 
        aAcuteCounter = 0, eAcuteCounter = 0, iAcuteCounter = 0, oAcuteCounter = 0, uAcuteCounter = 0,
        aCrasisCounter = 0, eCrasisCounter = 0, iCrasisCounter = 0, oCrasisCounter = 0, uCrasisCounter = 0, 
        aTildeCounter = 0, oTildeCounter = 0, 
        aCircumflexCounter = 0, eCircumflexCounter = 0, iCircumflexCounter = 0, oCircumflexCounter = 0, uCircumflexCounter = 0,
        consonantCounter = 0, brCounter = 0, tableCounter= 0;

        String htmlString = getHtml(sentenceTwo);
        // htmlString = htmlString.toLowerCase();
        //sentenceOne = sentenceOne.toLowerCase();

        for (int index = 0; index < htmlString.length(); index++) {
            //Normal vowels counter
            if (htmlString.charAt(index) == 'a') {
                aCounter ++;
            }
            if (htmlString.charAt(index) == 'e') {
                eCounter ++;
            }
            if (htmlString.charAt(index) == 'i') {
                iCounter ++;
            }
            if (htmlString.charAt(index) == 'o') {
                oCounter ++;
            }
            if (htmlString.charAt(index) == 'u') {
                uCounter ++;
            }

            //Vowels with acute counter
            if (htmlString.charAt(index) == 'á') {
                aAcuteCounter ++;
            }
            if (htmlString.charAt(index) == 'é') {
                eAcuteCounter ++;
            }
            if (htmlString.charAt(index) == 'í') {
                iAcuteCounter ++;
            }
            if (htmlString.charAt(index) == 'ó') {
                oAcuteCounter ++;
            }
            if (htmlString.charAt(index) == 'ú') {
                uAcuteCounter ++;
            }

            //Vowels with crasis counter
            if (htmlString.charAt(index) == 'à') {
                aCrasisCounter ++;
            }
            if (htmlString.charAt(index) == 'è') {
                eCrasisCounter ++;
            }
            if (htmlString.charAt(index) == 'ì') {
                iCrasisCounter ++;
            }
            if (htmlString.charAt(index) == 'ò') {
                oCrasisCounter ++;
            }
            if (htmlString.charAt(index) == 'ù') {
                uCrasisCounter ++;
            }

            //Vowels with tilde counter
            if (htmlString.charAt(index) == 'ã') {
                aTildeCounter ++;
            }
            if (htmlString.charAt(index) == 'õ') {
                oTildeCounter ++;
            }

            //Vowels with circumflex counter
            if (htmlString.charAt(index) == 'â') {
                aCircumflexCounter ++;
            }
            if (htmlString.charAt(index) == 'ê') {
                eCircumflexCounter ++;
            }
            if (htmlString.charAt(index) == 'î') {
                iCircumflexCounter ++;
            }
            if (htmlString.charAt(index) == 'ô') {
                oCircumflexCounter ++;
            }
            if (htmlString.charAt(index) == 'û') {
                uCircumflexCounter ++;
            }

            //Consonant counter
            String consonants = "bcdfghjklmnpqrstvwxyz";
            String possibleConsonant = Character.toString(htmlString.charAt(index));

            if (consonants.contains(possibleConsonant)) {
                consonantCounter ++;
            }
        }

        //<br> counter
        String substringBr = "<br>";
        
        int fromIndexBr = 0;
            
        while ((fromIndexBr = htmlString.indexOf(substringBr, fromIndexBr)) != -1) {
            brCounter ++;
            fromIndexBr += substringBr.length();
        }

        //<table> counter
        String subStringTable = "<table>";

        int fromIndexTable = 0;

        while ((fromIndexTable = htmlString.indexOf(subStringTable, fromIndexTable)) != -1) {
            tableCounter ++;
            fromIndexTable += subStringTable.length();
        }

        //site name declaration
        String siteName = sentenceOne;

        //return
        String htmlCounted = "a(" + (aCounter - 1) + ") e(" + (eCounter - 1) + ") i(" + iCounter + ") o(" + oCounter + 
        ") u(" + uCounter + ") á(" + aAcuteCounter + ") é(" + eAcuteCounter + ") í(" + iAcuteCounter + ") ó(" +
        oAcuteCounter + ") ú(" + uAcuteCounter + ") à(" + aCrasisCounter + ") è(" + eCrasisCounter + ") ì(" + 
        iCrasisCounter + ") ò(" + oCrasisCounter + ") ù(" + uCrasisCounter + ") ã(" + aTildeCounter + ") õ(" + 
        oTildeCounter + ") â(" + aCircumflexCounter + ") ê(" + eCircumflexCounter + ") î(" + iCircumflexCounter + 
        ") ô(" + oCircumflexCounter + ") û(" + uCircumflexCounter + ") consoante(" + (consonantCounter - 3) + 
        ") <br>(" + brCounter + ") <table>(" + tableCounter + ") " + siteName;

        return htmlCounted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineOne = scanner.nextLine();

        while (!lineOne.equals("FIM")) {
            String lineTwo = scanner.nextLine();

            MyIO.println(htmlGeneralCounter(lineOne, lineTwo));

            lineOne = scanner.nextLine();
        }

        scanner.close();
    }
}