package com.tagger;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;

import java.io.*;

/**
 * User: epeinado
 * Date: 21/07/14
 * Time: 14:45
 */
public class PruebasTika {

    private static final String RUTA_ARCHIVOS = "C:\\Users\\epeinado\\Documents\\Proyectos\\Eurosentiment\\Codigo\\propuestaTagger\\src\\main\\resources\\";

    private static final String FILE_TXT = RUTA_ARCHIVOS+"LaMetamorfosisCap1.txt";
    private static final String FILE_DOCX = RUTA_ARCHIVOS+"LaMetamorfosisCap1.docx";
    private static final String FILE_PDF = RUTA_ARCHIVOS+"LaMetamorfosisCap1.pdf";
    private static final String FILE_XML = RUTA_ARCHIVOS+"rssEFE.xml";
    private static final String FILE_HTML = RUTA_ARCHIVOS+"eurosentiment.htm";
    private static final String FILE_XLSX = RUTA_ARCHIVOS+"hotel_es.xlsx";
//    private static final String FILE_ODF = "C:\\Users\\epeinado\\Documents\\Proyectos\\Eurosentiment\\Codigo\\propuestaTagger\\src\\main\\resources\\***.odf";
    private static final String FILE_EPUB = RUTA_ARCHIVOS+"ElGuardianEntreElCenteno.epub";
    private static final String FILE_RTF = RUTA_ARCHIVOS+"LaMetamorfosisCap1.rtf";
    private static final String FILE_ZIP = RUTA_ARCHIVOS+"stopwords.zip";
    private static final String FILE_RAR = RUTA_ARCHIVOS+"FTT.rar";
    private static final String FILE_RSS = RUTA_ARCHIVOS+"MicrosiervosFeed.rss";
    private static final String FILE_MP3 = RUTA_ARCHIVOS+"Jacqueline.mp3";
    private static final String FILE_JPG = RUTA_ARCHIVOS+"DayOfTentacle.jpg";
    private static final String FILE_TIF = RUTA_ARCHIVOS+"ejemploTIF.tif";


    public static void main(String[] args) throws FileNotFoundException,
            IOException, org.xml.sax.SAXException, TikaException {

        File file = new File(FILE_TXT);
        InputStream is = new FileInputStream(file);
        Metadata metadata = new Metadata();
        BodyContentHandler ch = new BodyContentHandler(10*1024*1024);
        AutoDetectParser parser = new AutoDetectParser();

        String mimeType = new Tika().detect(file);
        metadata.set(Metadata.CONTENT_TYPE, mimeType);

        parser.parse(is, ch, metadata, new ParseContext());
        is.close();

        for ( int i = 0; i<metadata.names().length; i++) {
            String item = metadata.names()[i];
            System.out.println(item + " -- " + metadata.get(item));
        }

        System.out.println(ch.toString());
    }

}
