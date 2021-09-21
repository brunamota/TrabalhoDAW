import { FiArrowRightCircle, FiArrowLeftCircle } from 'react-icons/fi'
import { Table } from 'react-bootstrap';

import logoImage from 'assets/images/user.png'

import 'pages/Coordenador/style.css'
import NavBar from 'componets/basics/navbar';
import Footer from 'componets/basics/footer';

const Coordenador: React.FC = () => {

  return (
    <>
    <div>
      <NavBar />
    </div>

    <div className="vagas-container">
      <header>
        <img src={logoImage} alt="Job Pool" />
        <span>Bem-vindo, <strong>{"Empresa"}</strong>!</span>
      </header>

      <h1>Alunos cadidatados à vaga cadastrada</h1>

      <Table striped bordered hover className="text-center">
        <thead>
          <tr>
            <th>Nome</th>
            <th>CPF</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Curso</th>
            <th>Período</th>
            <th>Currículo</th>
          </tr>
        </thead>
        <tbody>
          {
            <tr>
              <td>Bruna</td>
              <td>000.000.000-01</td>
              <td>bruna@jp.com</td>
              <td>(61) 7070-7070</td>
              <td>Rua Osório de Assis,178, Jataí-GO</td>
              <td>Ciência da Computação</td>
              <td>4º</td>
              <td>
                <button type="button">
                  <FiArrowRightCircle size={20} color="#251FC5" />
                </button>
              </td>
            </tr>
          }
        </tbody>

        <tbody>
          {
            <tr>
              <td>Leonardo</td>
              <td>000.000.000-02</td>
              <td>leo@jp.com</td>
              <td>(64) 8070-8070</td>
              <td>Rua Zeca Vilela, 78, Jataí-GO</td>
              <td>Ciência da Computação</td>
              <td>4º</td>
              <td>
                <button type="button">
                  <FiArrowRightCircle size={20} color="#251FC5" />
                </button>
              </td>
            </tr>
          }
        </tbody>
      </Table>
    </div>
  <div>
  <Footer />
  </div>
    </>
  );
}
export default Coordenador;
