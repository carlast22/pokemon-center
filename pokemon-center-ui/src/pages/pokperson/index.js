import {React, useState} from 'react'
import Image from 'next/image'
import { useRouter } from 'next/router'
import Layout from "../../components/Layout"
import Link from 'next/link'
import { FaPlus } from 'react-icons/fa';

const PokemonPerson = ({pokemonPerson}) => {

  const router = useRouter()

  return (
    <Layout>
        <Link href="/pokperson/create">
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
            <span className="text-2xl mr-5 w-36">Nickname</span>
            <span className="text-2xl mr-5 w-36">Weight</span>
            <span className="text-2xl mr-5 w-36">Height</span>
          </div>
        </div>
      {
        pokemonPerson === null || pokemonPerson.lenght === 0 ? (
          <h2>There are no pokemon-persons</h2>
        ) : (
          <div className="w-full">
            {
              pokemonPerson.map((pokperson, i) => (
                <div 
                key={pokperson.pokemonPersonId}
                className="bg-white/70 backdrop-blur-xl hover:bg-white/80 shadow-md rounded cursor-pointer px-20 py-1 my-1 flex justify-start items-center">
                  <span className="text-2xl mr-5 w-32">{pokperson.pokemonPersonId}</span>
                  <span className="text-2xl mr-5 w-36">{pokperson.pokemonNickname}</span>
                  <span className="text-2xl mr-5 w-36">{pokperson.weight}</span>
                  <span className="text-2xl mr-5 w-36">{pokperson.height}</span>
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

PokemonPerson.getInitialProps = async (ctx) => {
  try {
    const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
    const res = await fetch(`${baseUrl}pokemonPerson/findAll`);
    const json = await res.json()
    return { pokemonPerson: json.data }
  } catch (ex) {
    return { pokemonPerson: [] };
  }
}

export default PokemonPerson