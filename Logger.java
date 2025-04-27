class Logger {
    private String filename;
    
    public Logger(String filename) {
        this.filename = filename;
        
        // it creates a log file if it doesn't exist
        try {
            java.io.File file = new java.io.File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            // this will add a header to the log file
            java.io.FileWriter fw = new java.io.FileWriter(file, true);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.write("=== Coffee Maker Log Started at " + new java.util.Date() + " ===\n");
            bw.close();
        } catch (java.io.IOException e) {
            System.out.println("Error creating log file: " + e.getMessage());
        }
    }
    
    public void log(String message) {
        try {
            java.io.FileWriter fw = new java.io.FileWriter(filename, true);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);
            bw.write(new java.util.Date() + ": " + message + "\n");
            bw.close();
        } catch (java.io.IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
