using IoCAutoFacAttributes.Interfaces;

namespace IoCAutoFacAttributes.Dependencies
{
    public class PriceService : IService
    {
        private string _name;
        public PriceService(string name)
        {
            _name = name;
        }
        public override string ToString()
        {
            return base.ToString() + " " + _name;
        }
    }
}
