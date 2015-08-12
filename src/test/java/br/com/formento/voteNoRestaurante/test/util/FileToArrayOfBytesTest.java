package br.com.formento.voteNoRestaurante.test.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.voteNoRestaurante.util.FileToArrayOfBytes;

public class FileToArrayOfBytesTest {
	private FileToArrayOfBytes fileToArrayOfBytes;
	private String fileName;
	private String pathDir;

	@Before
	public void instanciar() {
		fileToArrayOfBytes = new FileToArrayOfBytes();
		fileName = "initApp/1pizzaria_pizza_hut.png";
		pathDir = fileToArrayOfBytes.getPathDir(fileName);
	}

	@Test
	public void testPathDir() {
		assertNotNull(pathDir);
		File f = new File(pathDir);
		assertTrue(f.exists());
	}

	@Test
	public void testFileRead() {
		byte[] fileRead = fileToArrayOfBytes.fileRead(pathDir);
		assertNotNull(fileRead);
	}

}
