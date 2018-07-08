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
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MatrixMultiplication{
	public static class Map1 extends Mapper<LongWritable,Text,IntWritable,Text>{
		// public Text file = new Text();
		IntWritable j = new IntWritable();
		Text value = new Text();
		public void map(LongWritable key, Text value,Context context ) throws IOException, InterruptedException {
			String file = new String(value.toString());
			String[] lines = file.split("\r\n|\r|\n");
			for (int i =0; i < lines.length ;i++ ) {
				String sub1 = lines[i].substring(0,1);
				System.out.println(sub1);
				String sub2 = file.substring(2,3);
				sub1 += file.substring(3,lines[i].length());
				context.write(j,value);
			}

		}
	}
	public static class Reduce1 extends Reducer<Text,Text, Text, Text >{

	} 
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		Job job = new Job(conf,"Matrix Multiplication");
		job.setJarByClass(MatrixMultiplication.class);
		job.setMapperClass(Map1.class);
		job.setReducerClass(Reduce1.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
