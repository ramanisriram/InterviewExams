package testdome;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
        for(int i=0; i<newPath.length(); i++) {
        	if(String.valueOf(newPath.charAt(i)).equals(".")) {
        		i++;
        		this.path = this.path.substring(0, this.path.length() - 2);
        	} else if (String.valueOf(newPath.charAt(i)).equals("/")) {
        		this.path = this.path.concat("/");
        	} else {
        		this.path = this.path.concat(String.valueOf(newPath.charAt(i)));
        	}
        }
        System.out.println("Final:"+this.path);
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("/");
        System.out.println(path.getPath());
    }
}