package se.r2m.spring.ovning1.bean;

import java.util.zip.Checksum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringChecksumCrc32Impl implements SpringChecksum {

	@Autowired
	private Checksum checksum;
	
	public Checksum getChecksum() {
		return checksum;
	}

	public void setChecksum(Checksum checksum) {
		this.checksum = checksum;
	}

	@Override
	public long calculateHash(String input) {
		byte bytes[] = input.getBytes();
		checksum.update(bytes, 0, bytes.length);
		long checksumValue = checksum.getValue();
		return checksumValue;
	}

}
