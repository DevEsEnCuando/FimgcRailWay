import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import Tab from 'react-bootstrap/Tab';
import Tabs from 'react-bootstrap/Tabs';

const BandejaExpedientes = () => {

  //Esta vista solo la ve el secretario de escuela y el decano 
  /*const [expediente, setExpediente]=useState();
  useEffect(()=>{
      //endpoint
      const URL='elurl/api/'
      axios.get(URL)
          .then(res=>setExpediente(res.data.results[ndiceDondeSeEncuentranLosExpedientes]))
          .catch(err=>console.log(err))
  },[])

  console.log(expediente)*/

  return (
    <div>
      <Tabs defaultActiveKey="expedientes-pendientes" className="mb-3">
        <Tab tabClassName='horizontal-nav-link' eventKey="expedientes-pendientes" title="Expedientes pendientes">
          <Container>
            <legend className='customize-legend-2 text-uppercase'>Expedientes pendientes</legend>
            <Table responsive="sm" className='table-container'>
              <thead className='thead-text-customize'>
                <tr>
                  <th>Nº de expediente</th>
                  <th>Nombre</th>
                  <th>Fecha de recepción</th>
                  <th>Envío a comisión</th>
                  <th>Escuela</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Nº de expediente</td>
                  <td>Nombre</td>
                  <td>Fecha de recepción</td>
                  <td>Si/No (Boolean)</td>
                  <td>Escuela</td>
                  <td><Button size="sm" variant="outline-success btn-into-table">Ver <i className="fi fi-bs-eye"></i></Button></td>
                </tr>
              </tbody>
            </Table>
          </Container>
        </Tab>
        <Tab tabClassName='horizontal-nav-link' eventKey="expedientes-firmados" title="Expedientes firmados">
          <Container>
            <legend className='customize-legend-2 text-uppercase'>Expedientes firmados</legend>
            <Table responsive="sm" className='table-container'>
              <thead className='thead-text-customize'>
                <tr>
                  <th>Nº de expediente</th>
                  <th>Nombre</th>
                  <th>Fecha de recepción</th>
                  <th>Envío a comisión</th>
                  <th>Escuela</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Nº de expediente</td>
                  <td>Nombre</td>
                  <td>Fecha de recepción</td>
                  <td>Si/No (Boolean)</td>
                  <td>Escuela</td>
                  <td><Button size="sm" variant="outline-success btn-into-table">Ver <i className="fi fi-bs-eye"></i></Button></td>
                </tr>
              </tbody>
            </Table>
          </Container>
        </Tab>
      </Tabs>
    </div>
  )
}

export default BandejaExpedientes