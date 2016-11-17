package ru.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxmoised on 17.11.2016.
 */
public class ContactGenerator {
    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = " Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactGenerator generator = new ContactGenerator();
        JCommander jComander = new JCommander(generator);
        try {
            jComander.parse(args);
        } catch (ParameterException ex) {
            jComander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCSV(contacts, new File(file));
        }
        else if(format.equals("xml")) {
            saveAsXML(contacts, new File(file));}
        else {
            System.out.println("не поддерживается формат" +  format);
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private  void saveAsCSV(List<ContactData> contacts, File file) throws IOException{
        Writer writer = new FileWriter(file);
        for (ContactData group: contacts){
            writer.write(String.format("%s\n", group.getFirstname()));
        }
        writer.close();
    }
    private  List<ContactData> generateContacts(int count){

        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i =0; i < count; i++) {
            contacts.add(new ContactData()
                    .withFirstname(String.format("test %s", i))
                    .withLastname(String.format("test %s", i))
                    .withGroup(String.format("test %s", i)));

        }
        return contacts;
    }
}
