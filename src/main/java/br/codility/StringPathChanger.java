package br.codility;

public class StringPathChanger {

    public String changeDirectoryString(String currentDirectory, String command){
        String[] directories = currentDirectory.split("/");

        String[] comandList = command.split(" ");
        if(!comandList[0].equals("cd")){
            throw new IllegalStateException("invalid command");
        }
        String result = "";
        if(comandList[1].equals("/")){
           return "/";

        } else if(comandList[1].equals("..")){
            result = "";
            for (int i = 1; i < directories.length-1; i++) {
                result = result +"/" + directories[i];
            }
            return result;
        }

        else if(comandList[1].equals("../..")){

            for (int i = 1; i < directories.length-2; i++) {
                result = result +"/" + directories[i];
            }
            return result;
        }
        else if(comandList[1].startsWith("../")){
            String subpath = comandList[1].substring(3);

            for (int i = 1; i < directories.length-1; i++) {
                result = result +"/" + directories[i];
            }
            return result + "/" + subpath;

        }else if(comandList[1].startsWith("/")){
            result = comandList[1];
        }
        else {
            for (int i = 1; i < directories.length; i++) {
                result = result + "/" + directories[i];
            }
            result =  result + "/" + comandList[1];
        }
        if(result.endsWith("/")){
            result = result.substring(0, result.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        StringPathChanger pathChanger = new StringPathChanger();
        String s = pathChanger.changeDirectoryString("/test/task/java", "cd /test/task");
        System.out.println(s);
    }
}
