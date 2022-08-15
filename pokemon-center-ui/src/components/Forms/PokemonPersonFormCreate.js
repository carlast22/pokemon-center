import {React, useState} from 'react'
import TextBox from '../Inputs/TextBox'
import Button from '../Inputs/Button'
import DropDown from '../Inputs/DropDown'
import { useRouter } from 'next/dist/client/router'

const PokemonPersonFormCreate = () => {

    const router = useRouter()

    const fakePersonList = [
        {
            id: 1,
            name: "Juan"
        },
        {
            id: 2,
            name: "Gabriel"
        }
    ]

    const fakePokemonList = [
        {
            id: 1,
            name: "Pikachu"
        },
        {
            id: 2,
            name: "Charmander"
        }
    ]

    const getPersons = () => {
        return fakePersonList.map((person) => {
          return <option key={person.id} value={person.id}>{person.name} 
                 </option>;
        });
    }

    const getPokemons = () => {
        return fakePokemonList.map((pokemon) => {
          return <option key={pokemon.id} value={pokemon.id}>{pokemon.name} 
                 </option>;
        });
    }

    const [pokemonPerson, setPokemonPerson] = useState({
        nickname: '',
        personId: 0,
        pokemonId: 0,
        weight: 0,
        height: 0
    })

    const handleChange = e => {
        const {name, value} = e.target
        setPokemonPerson({...pokemonPerson, [name]: value})
    }

    const handleSubmit = e => {
        e.preventDefault()

        const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(pokemonPerson)
        };
        fetch(`${baseUrl}person/pokemonPerson`, requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));

        router.push("/pokperson")
    }

  return (
    <form onSubmit={handleSubmit} className="my-2 p-10 rounded shadow-md bg-slate-900/90 text-white backdrop-blur-md">
        <h1 className='font-bold text-lg'>Pokemon & Trainer - Registry</h1>
        <div className='grid grid-cols-2 gap-4 my-10'>
            <TextBox type="text" name="nickname" label="Nickname:" onChange={handleChange} />
            <DropDown name='personId' onChange={handleChange} emptyMessage="Select a trainer" items={getPersons()} label="Trainer:"/>
            <DropDown name='pokemonId' onChange={handleChange} emptyMessage="Select a pokemon" items={getPokemons()} label="Pokemon:"/>
            <TextBox type="number" name="weight" label="Weight:" onChange={handleChange} />
            <TextBox type="number" name="height" label="Height:" onChange={handleChange} />
        </div>
        <Button text="Save" disabled={!pokemonPerson.nickname}/>
    </form>
  )
}

export default PokemonPersonFormCreate