package ru.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
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
public class GroupGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = " Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupGenerator generator = new GroupGenerator();
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
        List<GroupData> groups = generateGroups(count);
        if (format.equals("csv")) {
            saveAsCSV(groups, new File(file));
        }
        else if(format.equals("xml")) {
            saveAsXML(groups, new File(file));}
            else {
                System.out.println("не поддерживается формат" +  format);
            }
    }

    private void saveAsXML(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("group", GroupData.class);
        String xml = xstream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private  void saveAsCSV(List<GroupData> groups, File file) throws IOException{
         Writer writer = new FileWriter(file);
         for (GroupData group: groups){
             writer.write(String.format("%s\n", group.getName()));
         }
         writer.close();
    }
    private  List<GroupData> generateGroups(int count){

        List<GroupData> groups = new ArrayList<GroupData>();
        for (int i =0; i < count; i++) {
            groups.add(new GroupData()
                    .withName(String.format("test %s", i)));

        }
        return groups;
    }
}
