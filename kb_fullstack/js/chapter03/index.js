import fs from 'node:fs/promises';
import path from 'path';

(async () => {
  try {
    const data = await fs.readFile(
      path.join(path.dirname, '/example.txt'),
      'utf8'
    );
    console.log(data);
  } catch (error) {
    console.error(error);
  }
})();
