import java.io.File;
import java.util.HashSet;
import java.util.Map;

/**
 * Author: Varun Joshi
 * Implementation of the Lempel-Ziv-Welch(LZW) Compression Algorithm
 * Purpose: Just for Fun
 */

public class LZW<T> {

    // Compression Part of the Program
    File file;
    Map<Integer, T> compressionMap;
    T obj;

    // Only Useful Constructor of this program
    public LZW(File file, T obj){
        this.file = file;
        this.obj = obj;
    }

    // Default No-Args Constructor
    public LZW(){
    }

}
