/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx}",
    "./src/components/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      opacity: ['disabled'],
      backgroundImage: {
        'pokeball': "url('https://i.postimg.cc/SRT1z3hT/pokeball.png')",
      },
    },
  },
  plugins: [],
}
