import React from 'react'
import Layout from '../../components/Layout'
import Link from 'next/link'
import { FaPlus } from 'react-icons/fa';
import Image from 'next/image'

const MedicalRecord = ({medicalRecords}) => {

  return (
    <Layout>
        <Link href="/medicalrecord/create">
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
            <span className="text-2xl mr-5 w-36">Diagnostic</span>
            <span className="text-2xl mr-5 w-36">Observation</span>
            <span className="text-2xl mr-5 w-36">Trainer</span>
            <span className="text-2xl mr-5 w-36">Pokemon</span>
          </div>
        </div>
      {
        medicalRecords === null || medicalRecords.lenght === 0 ? (
          <h2>There are no medical records</h2>
        ) : (
          <div className="w-full">
            {
              medicalRecords.map((medical, i) => (
                <div 
                key={medical.medicalRecordId}
                className="bg-white/70 backdrop-blur-xl hover:bg-white/80 shadow-md rounded cursor-pointer px-20 py-1 my-1 flex justify-start items-center">
                  <span className="text-2xl mr-5 w-32">{medical.medicalRecordId}</span>
                  <span className="text-lg mr-5 w-36">{medical.diagnostic}</span>
                  <span className="text-lg mr-5 w-36">{medical.observation}</span>
                  <span className="text-lg mr-5 w-36">{medical.trainer.name}</span>
                  <span className="mr-5 w-80">
                    <div className='flex justify-start items-center'>
                      <Image src={medical.pokemon.image} width={60} height={60} alt="Picture"/>
                      <div>
                        <span><span className='font-bold'>Nickname:</span> {medical.trainerPokemon.pokemonNickname}</span>
                        <br/>
                        <span><span className='font-bold'>Original name:</span> {medical.pokemon.name}</span>
                      </div>
                    </div>
                    </span>
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

MedicalRecord.getInitialProps = async (ctx) => {
  try {
    const baseUrl = process.env.NEXT_PUBLIC_API_BASE_URL
    const res = await fetch(`${baseUrl}medicalRecordController/findByDoctorId/1`);
    const json = await res.json()
    return { medicalRecords: json.data }
  } catch (ex) {
    return { medicalRecords: [] };
  }
}

export default MedicalRecord