from setuptools import setup, find_packages

setup(
    name='apiverve_populationdata',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='A country population and demographic data API. Look up any country by ISO code to get its population data, with total population, growth rate, density, urban/rural breakdown, and life expectancy on paid plans.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/population?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
