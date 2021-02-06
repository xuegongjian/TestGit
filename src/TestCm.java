import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestCm {
	

	public static String exec(long timeout, String... cmd) throws Exception {

        if (null == cmd) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        BufferedReader br = null;
        BufferedReader ebr = null;
        InputStream in = null;
        InputStream ein = null;

        try {
            Process ps = null;

            if (cmd.length == 1) {
                ps = Runtime.getRuntime().exec(cmd[0]);
            }
            else {
                ps = Runtime.getRuntime().exec(cmd);
            }

            in = ps.getInputStream();
            ein = ps.getErrorStream();

            br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                output.append(line + "\n");
            }

            ebr = new BufferedReader(new InputStreamReader(ein));

            while ((line = ebr.readLine()) != null) {
                output.append(line + "\n");
            }

            ps.waitFor();
        }
        finally {
            if (br != null) {
                br.close();
            }
            if (ebr != null) {
                ebr.close();
            }
        }
        return output.toString();
    }
	
	public static void main(String[] args){
		try {
			exec(2000,args[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
