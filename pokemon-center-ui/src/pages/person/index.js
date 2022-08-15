import {React, useState} from 'react'
import Layout from '../../components/Layout'
import Link from 'next/link'
import TextBox from '../../components/Inputs/TextBox'
import Button from '../../components/Inputs/Button'
import { FaPlus, FaSearch } from 'react-icons/fa';

const Trainer = () => {

  const [data, setData] = useState([]);
  const [personName, setPersonName] = useState();

  const fetchData = async () => {
    const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
    const req = await fetch(`${baseUrl}person/findByName/${personName}`);
    const response = await req.json();
    console.log(response)
    return setData(response.data);
  };

  const handleChange = e => {
    const {name, value} = e.target
    setPersonName(value)
  }

  const handleClick = (event) => {
    event.preventDefault();
    fetchData();
  };

  return (
    <Layout>
        <Link href="/person/create">
          <a
            className={`bg-gradient-to-b from-slate-900 to-slate-800 hover:bg-gray-800 text-white px-5 py-2 shadow-md font-bold rounded inline-flex items-center`}
          >
            <FaPlus className='mr-4' />
            New
          </a>
        </Link>  
        <br/>
        <div className="my-2 px-10 py-5 rounded shadow-md bg-slate-900/90 text-white backdrop-blur-md">
          <div className='grid grid-cols-3 gap-4 my-1'>
            <div className='col-span-2'>
              <TextBox type="text" name="personName" label="Name:" onChange={handleChange} />
            </div>
              <button className="mt-6 w-7/12 bg-slate-800 hover:bg-slate-900 text-white px-5 py-2 shadow-md font-bold rounded inline-flex items-center disabled:opacity-50" 
              onClick={handleClick}><FaSearch className='mr-4'/>Search</button>
          </div>
        </div>
        <br/>
        <div className="justify-center">
        <div className="w-full">
          <div className="bg-gradient-to-b from-slate-900 to-slate-800 text-white shadow-md rounded cursor-pointer px-20 py-2 flex justify-start items-center">
            <span className="text-2xl mr-5 w-32">Id</span>
            <span className="text-2xl mr-5 w-36">Identification</span>
            <span className="text-2xl mr-5 w-36">Name</span>
            <span className="text-2xl mr-5 w-36">Lastname</span>
            <span className="text-2xl mr-5 w-36">Email</span>
          </div>
        </div>
      {
        data === null || data.lenght === 0 ? (
          <h2>There are no trainers</h2>
        ) : (
          <div className="w-full">
            {
              data.map((person, i) => (
                <div 
                key={person.id}
                className="bg-white/70 backdrop-blur-xl hover:bg-white/80 shadow-md rounded cursor-pointer px-20 py-1 my-1 flex justify-start items-center">
                  <span className="text-2xl mr-5 w-32">{person.id}</span>
                  <span className="text-2xl mr-5 w-36">{person.identification}</span>
                  <span className="text-2xl mr-5 w-36">{person.name}</span>
                  <span className="text-2xl mr-5 w-36">{person.lastName}</span>
                  <span className="text-2xl mr-5 w-36">{person.email}</span>
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

export default Trainer