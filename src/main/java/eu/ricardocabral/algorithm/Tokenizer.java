package eu.ricardocabral.algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

/**
 * This class is thread safe.
 */
public class Tokenizer {
	private File file;

	public synchronized void setFile(File f) {
		file = f;
	}

	public synchronized File getFile() {
		return file;
	}

	// Severe issue related to lack of synchronization, null pointer in case a file
	// does not exist, Also FileInputStream is not threadSafe
	public String getContent() throws IOException {
		checkReadFile();
		synchronized (file) {
			return Files.lines(file.toPath()).parallel().collect(Collectors.joining());
		}

	}

	// Severe issue related to lack of synchronization, file validation
	//I've never done before the POSIX replace, so I would test it more.
	public String getContentWithoutUnicode() throws IOException {
		checkReadFile();
		synchronized (file) {
			return Files.lines(file.toPath()).parallel().map(text -> text.replaceAll("\\P{Print}", ""))
					.collect(Collectors.joining());
			// p{Print} represents a POSIX character class for printable ASCII characters
		}

	}

	// Severe issue related to lack of synchronization, FileOutputStream is not threadSafe
	public void saveContent(String content) throws IOException {
		checkWriteFile();
		synchronized (file) {
			Files.write(file.toPath(), content.getBytes());
		}
	}

	// We could create a exception to deal with it like (FileValidationException)
	private void checkReadFile() throws IOException {
		if (!file.exists() && !file.canRead()) {
			throw new IOException("Please check if the file exists or if you have rights to open it");
		}

	}
	
	//same comment as above
	private void checkWriteFile() throws IOException {
		if (!file.canWrite()) {
			throw new IOException("Please check if the file exists or if you have rights to open it");
		}

	}
}
