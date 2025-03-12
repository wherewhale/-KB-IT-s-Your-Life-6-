const one = () => Promise.resolve('One!');

async function main() {
  async function myFunc() {
    console.log('In Function!');
    const res = await one();
    console.log(res);
  }

  console.log('Before function!');
  await myFunc();
  console.log('After function!');
}

main();
