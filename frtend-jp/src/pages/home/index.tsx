import NavBar from 'componets/basics/navbar';
import Footer from 'componets/basics/footer';
import { FiLogIn } from 'react-icons/fi';


import './styles.css';
import logo from '../../assets/images/Logo.png';

const Home: React.FC = () => {
  return (
    <>
      <div id="header">
      </div>
      <div id="conteudo">
        <div id="contentl">
          <p><h1><strong>Sistema de seleção de estágios para os alunos da UFJ.</strong></h1></p>
          <p></p>
          <a href="/autentica">
            <span>
              <FiLogIn />
            </span>
            <strong>Acessar o sistema</strong>
          </a>
        </div>
        <div id="contentr">
          <img src={logo} alt="Job Pool" />
        </div>
      </div>
      <div id="footer">
      </div>
    </>
  );
}

export default Home;

