package com.oreon.cerebrum.web.action.commerce;

import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.mahout.math.DenseVector;
import org.apache.mahout.math.NamedVector;

public class Snippet {
	public static void main(String args[]) throws Exception {
		List<NamedVector> apples = new ArrayList<NamedVector>();
		NamedVector apple;
		apple = new NamedVector(new DenseVector(new double[] { 0.11, 510, 1 }),
				"Small round green apple");
		apples.add(apple);
		apple = new NamedVector(new DenseVector(new double[] { 0.23, 650, 3 }),
				"Large oval red apple");
		apples.add(apple);
		apple = new NamedVector(new DenseVector(new double[] { 0.09, 630, 1 }),
				"Small elongated red apple");
		apples.add(apple);
		apple = new NamedVector(new DenseVector(new double[] { 0.25, 590, 3 }),
				"Large round yellow apple");
		apples.add(apple);
		apple = new NamedVector(new DenseVector(new double[] { 0.18, 520, 2 }),
				"Medium oval green apple");
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get

		// Path path = new Path("appledata/apples");
		// SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf
	}

}
