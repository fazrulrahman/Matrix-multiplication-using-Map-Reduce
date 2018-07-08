import java.io.IOException;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class MatrixMultiplication{
	public static class Map extends Mapper<LongWritable,Text,Text,Text>{

	}
	public static class Reduce extends Reducer<Text,Text, Text, Text >{

	} 
	public static void main(String[] args) {
		
	}
}
