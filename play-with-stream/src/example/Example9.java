package example;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;

class Accumulator {
	public long total = 0;  // mutable variable

	public synchronized void add(long value) {
		total += value;
	}
}

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Fork(value = 2, jvmArgs = { "-Xms4G", "-Xmx4G" })
public class Example9 {

	private static final long N = 10_000_000L;

	public static void main(String[] args) {
		
		
		long result=sideEffectSum();
		System.out.println(result);
	

	}

//	@Benchmark
	public static long sequantialSum() {
		return Stream.iterate(1L, i -> i + 1).limit(N).reduce(0L, Long::sum);
	}

	// @Benchmark
	public long iterativeSum() {
		long result = 0;
		for (int i = 0; i < N; i++) {
			result += 1;
		}
		return result;
	}

	// @Benchmark
	public static long parallelSum() {
		return Stream.iterate(1L, i -> i + 1).limit(N).parallel().reduce(0L, Long::sum);
	}

//	@Benchmark
	public static long rangedSum() {
		return LongStream.rangeClosed(1, N).parallel().reduce(0L, Long::sum);
	}
	
	@Benchmark
	public static long sideEffectSum() {
		Accumulator accumulator=new Accumulator();
		 LongStream.rangeClosed(1, N)
				.parallel()
				.forEach(accumulator::add);
		 return accumulator.total;
	}

}
