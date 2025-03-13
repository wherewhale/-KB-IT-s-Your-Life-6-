const fs = require('node:fs/promises');

(async () => {
  try {
    const data = await fs.readFile('./example.txt', 'utf8');
    console.log(data);
  } catch (error) {
    console.error(error);
  }
})();
