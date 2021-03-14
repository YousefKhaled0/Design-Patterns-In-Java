package builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodeBuilder {
    private String className;
    private List<String> fieldNames = new ArrayList<String>();
    private List<String> fieldTypes = new ArrayList<String>();
    private static final int i = 2;

    public CodeBuilder(String className) {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type) {
        fieldNames.add(name);
        fieldTypes.add(type);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        sb.append(className);
        sb.append("\n{\n");
        for (int i = 0; i < fieldNames.size(); i++) {
            sb.append(String.join("", Collections.nCopies(CodeBuilder.i, " ")));
            sb.append(fieldTypes.get(i));
            sb.append(" ");
            sb.append(fieldNames.get(i));
            sb.append(";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(codeBuilder);
    }

}