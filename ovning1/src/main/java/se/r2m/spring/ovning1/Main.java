package se.r2m.spring.ovning1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.base.Joiner;

import se.r2m.spring.ovning1.bean.SpringChecksum;

public class Main {

	@Autowired
	private static SpringChecksum checksum;

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml")) {
			System.out.println("ApplicationContext: " + ctx);
			if (args.length < 1) {
				System.out.println("Användning: crc32checksum <sträng>");
				return;
			}
			String input = Joiner.on(" ").join(args);
			System.out.print(input + " har CRC32 ");
			System.out.println(checksum.calculateHash(input));
		}
	}

}
