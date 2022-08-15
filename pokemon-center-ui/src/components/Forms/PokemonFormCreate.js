import {React, useState} from 'react'
import TextBox from '../Inputs/TextBox'
import Button from '../Inputs/Button'
import { useRouter } from 'next/dist/client/router'

const PokemonFormCreate = () => {

    const router = useRouter()

    const [pokemon, setPokemon] = useState({
        name: ''
    })

    const handleChange = e => {
        const {name, value} = e.target
        setPokemon({...pokemon, [name]: value})
    }

    const handleSubmit = e => {
        e.preventDefault()

        const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pokemon)
        };
        fetch(`${baseUrl}pokemon/create`, requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));

        router.push("/pokemon")
    }

  return (
    <form onSubmit={handleSubmit} className="my-2 p-10 rounded shadow-md bg-slate-900/90 text-white backdrop-blur-md">
        <h1 className='font-bold text-lg'>Pokemon - Registry</h1>
        <div className='grid grid-cols-1 gap-4 my-10'>
            <TextBox type="text" name="name" label="Name:" onChange={handleChange} />
        </div>
        <Button text="Save" disabled={!pokemon.name}/>
    </form>
  )
}

export default PokemonFormCreate