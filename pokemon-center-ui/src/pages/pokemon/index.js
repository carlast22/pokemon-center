import {React} from 'react'
import Image from 'next/image'
import Layout from "../../components/Layout"
import Link from 'next/link'
import { FaPlus } from 'react-icons/fa';

const Pokemon = ({pokemons}) => {

  return (
    <Layout>
        <Link href="/pokemon/create">
          <a
            className={`bg-gradient-to-b from-slate-900 to-slate-800 hover:bg-gray-800 text-white px-5 py-2 shadow-md font-bold rounded inline-flex items-center`}
          >
            <FaPlus className='mr-4' />
            New
          </a>
        </Link>  
        <br/>
        <br/>
        <div className="justify-center">
        <div className="w-full">
          <div className="bg-gradient-to-b from-slate-900 to-slate-800 text-white shadow-md rounded cursor-pointer px-20 py-2 flex justify-start items-center">
            <span className="text-2xl mr-5 w-32">Id</span>
            <span className="text-2xl mr-5 w-36">Image</span>
            <span className="text-2xl mr-5 w-36">Name</span>
            <span className="text-2xl mr-5 w-36">Habitat</span>
            <span className="text-2xl mr-5 w-36">Shape</span>
          </div>
        </div>
      {
        pokemons === null || pokemons.lenght === 0 ? (
          <h2>There are no pokemon</h2>
        ) : (
          <div className="w-full">
            {
              pokemons.map((pokemon, i) => (
                <div 
                key={pokemon.id}
                className="bg-white/70 backdrop-blur-xl hover:bg-white/80 shadow-md rounded cursor-pointer px-20 py-1 my-1 flex justify-start items-center">
                  <span className="text-2xl mr-5 w-32">{pokemon.id}</span>
                  <span className="text-2xl mr-5 w-36">
                  <Image src={pokemon.image} width={100} height={100} alt="Picture"/></span>
                  <span className="text-2xl mr-5 w-36">{pokemon.name}</span>
                  <span className="text-2xl mr-5 w-36">{pokemon.habitat}</span>
                  <span className="text-2xl mr-5 w-36">{pokemon.shape}</span>
                </div>
              ))
            }
          </div>
        )
      }
      </div>
    </Layout>
  )
}

Pokemon.getInitialProps = async (ctx) => {
  try {
    const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
    const res = await fetch(`${baseUrl}pokemon/findAll`);
    const json = await res.json()
    return { pokemons: json.data }
  } catch (ex) {
    return { pokemons: [] };
  }
}

export default Pokemon